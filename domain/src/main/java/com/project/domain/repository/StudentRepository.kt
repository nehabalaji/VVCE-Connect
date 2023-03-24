package com.project.domain.repository

import com.project.domain.models.Student

interface StudentRepository {
    fun getStudent(studentUsn: String): Student
    suspend fun insertStudent(student: Student)
}
