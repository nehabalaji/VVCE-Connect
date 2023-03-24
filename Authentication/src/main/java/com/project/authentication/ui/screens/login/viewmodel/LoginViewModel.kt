package com.project.authentication.ui.screens.login.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.project.domain.usecases.InsertStudentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel@Inject constructor(
    private val insertStudentUseCase: InsertStudentUseCase
) : ViewModel() {
    var auth = FirebaseAuth.getInstance()

    var email = mutableStateOf("").value
        private set

    var password = mutableStateOf("").value
        private set

    fun setEmail(inputString: String) {
        email = inputString
    }

    fun setPassword(inputString: String) {
        password = inputString
    }

    fun validateEmailId(): Boolean {
        return email.endsWith("@vvce.ac.in")
    }

    fun validatePassword(): Boolean {
        return password.length >= 8
    }

    fun loginUser(): Task<AuthResult> {
        return auth.signInWithEmailAndPassword(email, password)
    }
}
