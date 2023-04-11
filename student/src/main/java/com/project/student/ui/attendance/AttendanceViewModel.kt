package com.project.student.ui.attendance

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.project.domain.models.Attendance
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class AttendanceViewModel @Inject constructor() : ViewModel() {

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val db = Firebase.firestore
    private val TAG = "response"

    private val _courseList = MutableStateFlow<Flow<List<Attendance>>>(emptyFlow())
    val courseList = _courseList.asStateFlow()

    init {
        auth.currentUser?.email?.let {
            getStudentCourses(it)
        }
    }

    private fun getStudentCourses(email: String) {
        val docRef = db.collection("student").document(email)
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    try {
                        val array = (document.data as Map<String, *>).toList()
                        array.forEach {
                            if (it.first == "subjects") {
                                val arr = it.second as List<Map<String, String>>
                                val attendanceList = mutableListOf<Attendance>()
                                arr.forEach {
                                    attendanceList.add(
                                        Attendance(
                                            subject_code = it["subject_code"] ?: "",
                                            subject_title = it["subject_title"] ?: "",
                                            attended = it["attended"]?.toInt() ?: 0,
                                            missed = it["missed"]?.toInt() ?: 0,
                                        ),
                                    )
                                }
                                _courseList.value = flow {
                                    emit(attendanceList)
                                }
                            }
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                } else {
                    Log.d(TAG, "No such document")
                }
            }
    }
}
