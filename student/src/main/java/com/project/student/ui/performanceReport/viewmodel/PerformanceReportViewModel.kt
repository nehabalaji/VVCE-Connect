package com.project.student.ui.performanceReport.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class PerformanceReportViewModel @Inject constructor() : ViewModel() {
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val db = Firebase.firestore

    private val _loading = MutableStateFlow<Flow<Boolean>>(emptyFlow())
    val loading = _loading.asStateFlow()

    private val _ia1Marks = MutableStateFlow<Flow<String>>(emptyFlow())
    val ia1Marks = _ia1Marks.asStateFlow()

    private val _ia2Marks = MutableStateFlow<Flow<String>>(emptyFlow())
    val ia2Marks = _ia2Marks.asStateFlow()

    private val _ia3Marks = MutableStateFlow<Flow<String>>(emptyFlow())
    val ia3Marks = _ia3Marks.asStateFlow()

    private val _quizMarks = MutableStateFlow<Flow<String>>(emptyFlow())
    val quizMarks = _quizMarks.asStateFlow()

    private val _subjects = MutableStateFlow<Flow<List<String>>>(emptyFlow())
    val subjects = _subjects.asStateFlow()

    private val subjectList = arrayListOf<String>()

    init {
        auth.currentUser?.email?.let {
            _loading.value = flowOf(true)
            db.collection("student").document()
            val docRef = db.collection("student").document(it).get()
            docRef.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val subjects = task.result.get("subjects") as ArrayList<Map<String, String>>
                    for (subject in subjects) {
                        subjectList.add(subject["subject_title"].toString())
                    }
                    _subjects.value = flow { emit(subjectList) }
                    _loading.value = flowOf(false)
                } else {
                    _loading.value = flowOf(false)
                    Log.d("TAG", "Error getting documents: ", task.exception)
                }
            }
        }
    }

    fun getIaMarksForSubject(subjectTitle: String) {
        auth.currentUser?.email?.let {
            db.collection("student").document(it).get().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val subjects = task.result.get("subjects") as ArrayList<Map<String, String>>
                    for (subject in subjects) {
                        if (subject["subject_title"].toString() == subjectTitle) {
                            _ia1Marks.value = flowOf(subject["ia1"].toString())
                            _ia2Marks.value = flowOf(subject["ia2"].toString())
                            _ia3Marks.value = flowOf(subject["ia3"].toString())
                            _quizMarks.value = flowOf(subject["quiz"].toString())
                            Log.v("TAG", subject["ia1"].toString()+subject["ia2"].toString()+subject["ia3"].toString())
                        }
                    }
                }
            }
        }
    }
}
