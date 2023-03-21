package com.project.data.repository

import com.project.data.mappers.toStudent
import com.project.data.sources.local.Dao
import com.project.domain.models.Student
import com.project.domain.repository.StudentRepository
import javax.inject.Inject

class StudentRepositoryImpl @Inject constructor(
    private val dao: Dao
) : StudentRepository {

    override suspend fun getStudent(studentUsn: String): Student {
        return dao.getStudent(studentUsn).toStudent()
    }
}
