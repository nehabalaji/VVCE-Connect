package com.project.data.mappers

import com.project.data.model.DCourseWorkDetails
import com.project.domain.models.CourseWorkDetails

fun CourseWorkDetails.toDCourseWorkDetails() = DCourseWorkDetails(name, date, link, type, course, sem)

fun DCourseWorkDetails.toCourseWorkDetails() = CourseWorkDetails(name, date, link, type, course, sem)
