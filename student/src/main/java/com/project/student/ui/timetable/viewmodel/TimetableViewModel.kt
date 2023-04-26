package com.project.student.ui.timetable.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.project.domain.usecases.GetStudentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TimetableViewModel @Inject constructor(
    getStudentUseCase: GetStudentUseCase
) : ViewModel() {
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val db = Firebase.firestore

    private val _timetableLink = MutableStateFlow<Flow<String>>(emptyFlow())
    val timetableLink = _timetableLink.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            auth.currentUser?.email?.let {
                val student = getStudentUseCase(it)
                db.collection("timetable").document(student?.branch.toString()).collection("link").document(student?.sem.toString()).get().addOnCompleteListener { it1 ->
                    if (it1.isSuccessful) {
                        _timetableLink.value = flowOf(it1.result.data?.get(student?.section).toString())
                    }
                }
            }
        }
    }
}
