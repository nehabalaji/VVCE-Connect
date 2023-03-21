package com.project.domain.usecases

import com.project.domain.repository.StudentRepository

class GetStudentUseCase(
    private val repository: StudentRepository
) {
    suspend operator fun invoke(usn: String) = repository.getStudent(usn)
}