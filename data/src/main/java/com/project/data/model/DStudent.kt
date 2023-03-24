package com.project.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DStudent(
    val name: String,
    val phone: String,
    @PrimaryKey(autoGenerate = false)
    val usn: String,
    val emailId: String,
    val yearOfJoining: String,
    val password: String,
    val role: String = "Student"
)
