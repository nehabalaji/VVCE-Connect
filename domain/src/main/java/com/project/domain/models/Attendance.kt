package com.project.domain.models

data class Attendance(
    val subject_code: String,
    val subject_title: String,
    val attended: Int,
    val missed: Int,
)
