package com.project.domain.models

data class Feedback(
    val subjectTitle: String,
    val subjectCode: String,
    val questions: List<Map<String, String>>,
    val feedbackGivenUid: List<String>,
)
