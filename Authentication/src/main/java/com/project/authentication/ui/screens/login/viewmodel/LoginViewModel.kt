package com.project.authentication.ui.screens.login.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.project.domain.models.Student
import com.project.domain.usecases.GetStudentUseCase
import com.project.domain.usecases.InsertStudentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel@Inject constructor(
    private val insertStudentUseCase: InsertStudentUseCase,
    private val getStudentUseCase: GetStudentUseCase
) : ViewModel() {
    var auth = FirebaseAuth.getInstance()
    private val db = Firebase.firestore

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

    fun insertStudent(student: Student) = viewModelScope.launch {
        insertStudentUseCase(student)
    }

    fun getStudentFromFireStore(emailId: String) = db.collection("student").document(emailId).get()

    fun getStudent(): Student? {
        return getStudentUseCase(email)
    }
}
