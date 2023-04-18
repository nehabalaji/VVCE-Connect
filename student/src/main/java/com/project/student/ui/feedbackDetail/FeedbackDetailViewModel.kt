package com.project.student.ui.feedbackDetail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.project.domain.models.Feedback
import com.project.domain.models.FeedbackQuestion
import com.project.domain.usecases.GetStudentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedbackDetailViewModel @Inject constructor(
    private val getStudentUseCase: GetStudentUseCase,
) : ViewModel() {
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val db = Firebase.firestore

    private val _questionsList = MutableStateFlow<Flow<List<FeedbackQuestion>>>(emptyFlow())
    val questionsList = _questionsList.asStateFlow()

    private val _feedbackCourseList = MutableStateFlow<Flow<Feedback>>(emptyFlow())

    fun getQuestions(subjectCode: String) {
        val email = auth.currentUser?.email
        viewModelScope.launch(Dispatchers.IO) {
            val student = email?.let { getStudentUseCase(it) }
            if (student != null) {
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

                                val questionsList = mutableListOf<FeedbackQuestion>()

                                val feedbackCourse = feedbackList.find {
                                    it.subjectCode == subjectCode
                                }

                                _feedbackCourseList.value = flow {
                                    if (feedbackCourse != null) {
                                        emit(feedbackCourse)
                                    }
                                }

                                feedbackCourse?.questions?.forEach {
                                    questionsList.add(
                                        FeedbackQuestion(
                                            question = it.keys.first(),
                                        ),
                                    )
                                }

                                _questionsList.value = flow {
                                    emit(questionsList)
                                }
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        }
                    }
            }
        }
    }

    fun onValueChanged(value: FeedbackQuestion) {
        viewModelScope.launch(Dispatchers.IO) {
            val currentList = _questionsList.value.first()
            val updatedQuestion = currentList.find {
                it.question == value.question
            }
            val position = currentList.indexOf(updatedQuestion)

            val updatedList: MutableList<FeedbackQuestion> = currentList.toMutableList()

            updatedList.removeAt(position)
            updatedList.add(position, value)

            _questionsList.value = flow {
                emit(updatedList)
            }
        }
    }

    fun onSubmitClicked() {
        viewModelScope.launch(Dispatchers.IO) {
            val email = auth.currentUser?.email
            val student = email?.let { getStudentUseCase(it) }

            if (student != null && auth.currentUser != null) {
                // val docRef = db.collection("feedback").document(student.branch)
                val currentFeedback = _feedbackCourseList.value.first()

                val updatedFeedbackUidList = mutableListOf<String>()
                updatedFeedbackUidList.addAll(currentFeedback.feedbackGivenUid)
                updatedFeedbackUidList.add(auth.currentUser!!.uid)

                val currentQuestions = _questionsList.value.first()

                currentQuestions.forEach { feedbackQuestion ->

                    val currentAnswersList = mutableListOf<String>()
                    val answerMap: HashMap<String, List<String>> = hashMapOf()

                    currentFeedback.questions.forEach {
                        if (it.keys.first() == feedbackQuestion.question) {
                            currentAnswersList.addAll(it.values)
                            currentAnswersList.add(feedbackQuestion.rating)
                            Log.v("studentdata", "$currentAnswersList")
                        }
                    }
                }
            }
        }
    }
}
