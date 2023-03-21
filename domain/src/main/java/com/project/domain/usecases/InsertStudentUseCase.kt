package com.project.domain.usecases

import com.project.domain.models.Student
import com.project.domain.repository.StudentRepository

class InsertStudentUseCase(
    private val repository: StudentRepository
) {
    suspend operator fun invoke(student: Student) = repository.insertStudent(student)
}