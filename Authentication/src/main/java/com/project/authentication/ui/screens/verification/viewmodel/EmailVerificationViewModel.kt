package com.project.authentication.ui.screens.verification.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.project.domain.usecases.GetStudentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EmailVerificationViewModel @Inject constructor(
    val getStudentUseCase: GetStudentUseCase
) : ViewModel() {

    var auth = FirebaseAuth.getInstance()
    var user = auth.currentUser

    var code = mutableStateOf("").value
        private set

    fun getStudentEmail(usn: String): String {
        return getStudentUseCase(usn)?.emailId.toString()
    }

    fun verifyEmailAddress(email: String) = user?.sendEmailVerification()
}
