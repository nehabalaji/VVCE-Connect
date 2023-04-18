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

    private val _studentSubjectsList =
        MutableStateFlow<Flow<List<Map<String, String>>>>(emptyFlow())

    fun getQuestions(subjectCode: String) {
        val email = auth.currentUser?.email
        viewModelScope.launch(Dispatchers.IO) {
            val student = email?.let { getStudentUseCase(it) }
            if (student != null) {
                val docRef = db.collection("feedback").document("CS").collection(student.sem)
                    .document(student.section.uppercase())
                docRef.get()
                    .addOnSuccessListener { document ->
                        if (document != null) {
                            try {
                                val studentSubjects =
                                    document.data?.get("subjects") as List<Map<String, String>>
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

                                Log.v("updated", "${document.data?.get("subjects")}")

                                _studentSubjectsList.value = flow {
                                    emit(studentSubjects)
                                }

                                val questionsList = mutableListOf<FeedbackQuestion>()

                                val feedbackCourse = feedbackList.find {
                                    it.subjectCode == subjectCode
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

    fun onSubmitClicked(subjectCode: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val email = auth.currentUser?.email
            val student = email?.let { getStudentUseCase(it) }

            try {
                if (student != null && auth.currentUser != null) {
                    val currentUserUid = auth.currentUser!!.uid
                    val updatedCourseFeedback = mutableListOf<Any>()
                    _studentSubjectsList.value.first().forEachIndexed { index, it ->
                        if (it["subject_code"] == subjectCode) {
                            val feedbackGivenUidList = it["feedback_given_uid"] as List<String>
                            val questions = it["questions"] as List<Map<String, Map<String, String>>>

                            val updatedFeedbackGivenUidList = mutableListOf<String>()

                            if (!feedbackGivenUidList.contains(currentUserUid)) {
                                updatedFeedbackGivenUidList.addAll(feedbackGivenUidList)
                                updatedFeedbackGivenUidList.add(currentUserUid)
                            }

                            val currentList = _questionsList.value.first()
                            val updatedFeedbackList = mutableListOf<HashMap<String, HashMap<String, List<String>>>>()

                            questions.forEach { map ->
                                val updatedAnswersMap = hashMapOf<String, List<String>>()
                                val updatedFeedbackMap = hashMapOf<String, HashMap<String, List<String>>>()
                                currentList.forEach { question ->
                                    if (map.containsKey(question.question)) {
                                        val updatedAnswersList = mutableListOf<String>()
                                        val answers = map[question.question] as Map<String, String>
                                        val answersList = answers["answers"] as List<String>

                                        updatedAnswersList.addAll(answersList)
                                        updatedAnswersList.add(question.rating)
                                        updatedAnswersMap["answers"] = updatedAnswersList
                                        updatedFeedbackMap[question.question] = updatedAnswersMap
                                        updatedFeedbackList.add(updatedFeedbackMap)
                                    }
                                }
                            }

                            val feedbackObject = hashMapOf(
                                "feedback_given_uid" to updatedFeedbackGivenUidList,
                                "questions" to updatedFeedbackList,
                                "subject_code" to subjectCode,
                                "subject_title" to it["subject_title"],
                            )
                            updatedCourseFeedback.add(index, feedbackObject)
                        } else {
                            updatedCourseFeedback.add(it)
                        }
                    }
                    val docRef = db.collection("feedback").document("CS").collection(student.sem).document(student.section.uppercase())
                    docRef.set(
                        hashMapOf(
                            "subjects" to updatedCourseFeedback,
                        ),
                    )
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
