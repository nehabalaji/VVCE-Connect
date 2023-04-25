package com.project.student.ui.dashboard.viewmodel

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
class StudentDashboardViewModel @Inject constructor(
    val getStudentUseCase: GetStudentUseCase
) : ViewModel() {

    private val _screen = MutableStateFlow<Flow<String>>(emptyFlow())
    val screen = _screen.asStateFlow()

    private val _student = MutableStateFlow<Flow<Student?>>(emptyFlow())
    val student = _student.asStateFlow()
    fun getStudent(email: String) = viewModelScope.launch(Dispatchers.IO) {
        _student.value = flowOf(getStudentUseCase(email))
    }

    fun setScreen(screenName: String) {
        _screen.value = flowOf(screenName)
    }
}
