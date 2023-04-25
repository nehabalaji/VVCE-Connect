package com.project.student.ui.profile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.project.domain.models.Student
import com.project.domain.usecases.GetStudentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StudentProfileViewModel @Inject constructor(
    val getStudentUseCase: GetStudentUseCase
) : ViewModel() {

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _student = MutableStateFlow<Flow<Student>>(emptyFlow())
    val student = _student.asStateFlow()

    init {
        auth.currentUser?.email?.let {
            getStudent(it)
        }
    }

    private fun getStudent(email: String) = viewModelScope.launch(Dispatchers.IO) {
        val studentValue = getStudentUseCase(email)
        studentValue?.let {
            _student.value = flowOf(it)
        }
    }

    fun logout() {
        auth.signOut()
    }
}
