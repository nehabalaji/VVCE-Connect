package com.project.data.repository

import com.project.data.mappers.toDStudent
import com.project.data.mappers.toStudent
import com.project.data.sources.local.Dao
import com.project.domain.models.Student
import com.project.domain.repository.StudentRepository
import javax.inject.Inject

class StudentRepositoryImpl @Inject constructor(
    private val dao: Dao,
) : StudentRepository {

    override fun getStudent(email: String): Student? {
        return dao.getStudent(email)?.toStudent()
    }

    override suspend fun insertStudent(student: Student) {
        dao.insertStudent(student.toDStudent())
    }
}
