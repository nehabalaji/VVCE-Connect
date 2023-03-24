package com.project.domain.models

data class Student(
    val name: String,
    val phone: String,
    val usn: String,
    val emailId: String,
    val yearOfJoining: String,
    val password: String,
    val role: String = "Student"
)
