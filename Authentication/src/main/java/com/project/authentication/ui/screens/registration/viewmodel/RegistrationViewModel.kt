package com.project.authentication.ui.screens.registration.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.project.domain.models.Student
import com.project.domain.usecases.InsertStudentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val insertStudentUseCase: InsertStudentUseCase
) : ViewModel() {

    private val db = Firebase.firestore
    var auth = FirebaseAuth.getInstance()

    var name = mutableStateOf("").value
        private set

    var phoneNumber = mutableStateOf("").value
        private set

    var usn = mutableStateOf("").value
        private set

    var email = mutableStateOf("").value
        private set

    var yearOfJoining = mutableStateOf("").value
        private set

    var password = mutableStateOf("").value
        private set

    var confirmPassword = mutableStateOf("").value
        private set

    fun setName(inputString: String) {
        name = inputString
    }

    fun setPhoneNumber(inputString: String) {
        phoneNumber = inputString
    }

    fun setUsn(inputString: String) {
        usn = inputString
    }

    fun setEmail(inputString: String) {
        email = inputString
    }

    fun setYearOfJoining(inputString: String) {
        yearOfJoining = inputString
    }

    fun setPassword(inputString: String) {
        password = inputString
    }

    fun setConfirmedPassword(inputString: String) {
        confirmPassword = inputString
    }

    fun validateName(): Boolean {
        return name.isNotBlank()
    }

    fun validatePhoneNumber(): Boolean {
        return phoneNumber.length == 10
    }

    fun validateUsn(): Boolean {
        return usn.length == 10
    }

    fun validateEmailId(): Boolean {
        return email.endsWith("@vvce.ac.in")
    }

    fun validatePassword(): Boolean {
        return password.length >= 8
    }

    fun validateConfirmedPassword(): Boolean {
        return password == confirmPassword
    }

    fun insertStudent() = viewModelScope.launch {
        insertStudentUseCase(Student(name, phoneNumber, usn, email, yearOfJoining, password))
    }

    fun registerStudent(): Task<AuthResult> {
        return auth.createUserWithEmailAndPassword(email, password)
    }

    fun addStudentToDb(student: HashMap<String, String>): Task<Void>? {
        return student["usn"]?.let {
            db.collection("student")
                .document(it)
                .set(student)
        }
    }
}
