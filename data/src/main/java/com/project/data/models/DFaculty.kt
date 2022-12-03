package com.project.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DFaculty(
    @PrimaryKey
    val facultyId: String,
    val name: String,
    val designation: String,
    val joiningDate: String,
    val classesHandled: List<DClass>,
    val subjectsHandled: List<DSubject>,
    val email: String,
    val password: String
)
