package com.project.vvce_connect.ui.screens.localdata

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

object CourseWorkData {

    fun getCourseWork():List<CourseWorkDetails>{
        val courseWork = listOf<CourseWorkDetails>(
            CourseWorkDetails(
                title = "PPT of module 1",
                date = "13/04/2023",
                icon = Icons.Filled.Slideshow,
                link = "Enter the link here"
            ),
            CourseWorkDetails(
                title = "Module 1 Lecture",
                date = "12/04/2023",
                icon = Icons.Filled.VideoFile,
                link = "Enter the link here"
            ),
            CourseWorkDetails(
                title = "Assignment SAN module 1",
                date = "01/04/2023",
                icon = Icons.Filled.Assignment,
                link = "Enter the link here"
            ),
            CourseWorkDetails(
                title = "Reference Material Module 1",
                date = "11/04/2023",
                icon = Icons.Filled.Link,
                link = "Enter the link here"
            ),
            CourseWorkDetails(
                title = "Last year Question Paper SAN",
                date = "07/04/2023",
                icon = Icons.Filled.Photo,
                link = "Enter the link here"
            )
        )

        return courseWork
    }
}