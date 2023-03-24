package com.project.domain.usecases

import com.project.domain.repository.StudentRepository

class GetStudentUseCase(
    private val repository: StudentRepository
) {
    operator fun invoke(usn: String) = repository.getStudent(usn)
}