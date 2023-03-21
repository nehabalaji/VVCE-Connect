package com.project.data.mappers

import com.project.data.model.DStudent
import com.project.domain.models.Student

fun Student.toDStudent() = DStudent(name, phone, usn, emailId, yearOfJoining, password, role)
fun DStudent.toStudent() = Student(name, phone, usn, emailId, yearOfJoining, password, role)