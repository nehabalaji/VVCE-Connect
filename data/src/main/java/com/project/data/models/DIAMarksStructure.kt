package com.project.data.models

data class DIAMarksStructure(
    val subject: DSubject,
    val marksObtained: Int,
    val totalMarks: Int = 30
)
