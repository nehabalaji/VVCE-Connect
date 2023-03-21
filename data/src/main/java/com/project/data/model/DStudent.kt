package com.project.data.model

data class DStudent(
    val name: String,
    val phone: String,
    val usn: String,
    val emailId: String,
    val yearOfJoining: String,
    val password: String,
    val role: String = "Student"
)
