package com.project.vvce_connect.ui.screens.student

import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

object StudentNavData {
    fun getBottomNavItems():List<StudentNavDetails> {
        val bottomNavItemList = listOf<StudentNavDetails>(
            StudentNavDetails(
                name = "Home",
                icon = Icons.Filled.Home
            ),
            StudentNavDetails(
                name = "Notification",
                icon = Icons.Filled.Notifications
            ),
            StudentNavDetails(
                name = "Setting",
                icon = Icons.Filled.Settings
            ),
            StudentNavDetails(
                name = "Profile",
                icon = Icons.Filled.Person
            )
        )
        return bottomNavItemList
    }

    fun getFeatureGridItems():List<StudentNavDetails>{
        val featureGridItemList = listOf<StudentNavDetails>(
            StudentNavDetails(
                name = "Attendance",
                icon = Icons.Filled.Rule
            ),
            StudentNavDetails(
                name = "Performance Report",
                icon = Icons.Filled.ChromeReaderMode
            ),
            StudentNavDetails(
                name = "Course Work",
                icon = Icons.Filled.Book
            ),
            StudentNavDetails(
                name = "Time Table",
                icon = Icons.Filled.CalendarMonth
            ),
            StudentNavDetails(
                name = "Placements",
                icon = Icons.Filled.SupervisedUserCircle
            ),
            StudentNavDetails(
                name = "Exam Form",
                icon = Icons.Filled.Description
            ),
            StudentNavDetails(
                name = "Exam Fee",
                icon = Icons.Filled.Payments
            ),
            StudentNavDetails(
                name = "Feedback",
                icon = Icons.Filled.RateReview
            )
        )

        return featureGridItemList
    }
}
