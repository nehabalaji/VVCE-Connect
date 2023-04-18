package com.project.student.ui.feedback

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.project.domain.models.Feedback
import com.project.domain.models.Student
import com.project.domain.usecases.GetStudentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedbackViewModel @Inject constructor(
    private val getStudentUseCase: GetStudentUseCase,
) : ViewModel() {
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val db = Firebase.firestore

    private val _courseList = MutableStateFlow<Flow<List<Feedback>>>(emptyFlow())
    val courseList = _courseList.asStateFlow()

    init {
        auth.currentUser?.email?.let {
            getStudentDetails(it)
        }
    }

    private fun getStudentDetails(email: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val student = getStudentUseCase(email)
            if (student != null) {
                getStudentFeedbackQuestions(student)
            }
        }
    }

    private fun getStudentFeedbackQuestions(student: Student) {
        val docRef = db.collection("feedback").document("CS").collection(student.sem).document(student.section.uppercase())
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    try {
                        val studentSubjects = document.data?.get("subjects") as List<Map<String, String>>
                        val feedbackList = mutableListOf<Feedback>()
                        studentSubjects.forEach {
                            feedbackList.add(
                                Feedback(
                                    subjectCode = it["subject_code"] ?: "",
                                    subjectTitle = it["subject_title"] ?: "",
                                    feedbackGivenUid = it["feedback_given_uid"] as List<String>,
                                    questions = it["questions"] as List<Map<String, String>>,
                                ),
                            )
                        }
                        val pendingFeedbackList = feedbackList.filter {
                            !it.feedbackGivenUid.contains(student.emailId)
                        }

                        _courseList.value = flow {
                            emit(pendingFeedbackList)
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
    }
}
