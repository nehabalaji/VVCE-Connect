package com.project.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DStudent(
    val name: String,
    val phone: String,
    val usn: String,
    @PrimaryKey(autoGenerate = false)
    val emailId: String,
    val yearOfJoining: String,
    val role: String = "Student"
)
