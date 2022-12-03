package com.project.data.models

import androidx.room.Embedded
import androidx.room.Entity

@Entity
data class Department(
    val departmentId: String,
    val departmentName: String,
    @Embedded
    val hod: DFaculty
)
