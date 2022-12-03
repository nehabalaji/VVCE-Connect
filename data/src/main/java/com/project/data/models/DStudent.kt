package com.project.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DStudent(
    @PrimaryKey
    val usn: String,
    val name: String,
    val email: String,
    val password: String,
    val phone: String,
    val admissionDate: String,
    val classEnrolled: DClass,
    val iaMarks: List<DIAMarksStructure>,
    val attendanceStatus: List<DAttendanceStructure>,
    val examFeePaid: Boolean = false,
    val examFormFilled: Boolean = false
)
