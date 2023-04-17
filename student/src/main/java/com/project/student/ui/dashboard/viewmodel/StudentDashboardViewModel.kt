package com.project.student.ui.dashboard.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class StudentDashboardViewModel @Inject constructor() : ViewModel() {

    private val _screen = MutableStateFlow<Flow<String>>(emptyFlow())
    val screen = _screen.asStateFlow()

    fun setScreen(screenName: String) {
        _screen.value = flowOf(screenName)
    }
}
