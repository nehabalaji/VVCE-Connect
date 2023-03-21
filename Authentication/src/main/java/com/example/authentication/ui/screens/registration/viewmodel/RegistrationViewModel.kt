package com.example.authentication.ui.screens.registration.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor() : ViewModel() {

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
}
