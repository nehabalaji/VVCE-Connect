package com.project.vvce_connect.ui.screens.localdata

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

object DashboardNavData {
    fun getBottomNavItems(): List<DashboardNavDetails> {
        val bottomNavItemList = listOf<DashboardNavDetails>(
            DashboardNavDetails(
                name = "Home",
                icon = Icons.Filled.Home,
            ),
            DashboardNavDetails(
                name = "Notification",
                icon = Icons.Filled.Notifications,
            ),
            DashboardNavDetails(
                name = "Setting",
                icon = Icons.Filled.Settings,
            ),
            DashboardNavDetails(
                name = "Profile",
                icon = Icons.Filled.Person,
            ),
        )
        return bottomNavItemList
    }

    fun getStudentDashboardItems(): List<DashboardNavDetails> {
        val studentDashboardItems = listOf<DashboardNavDetails>(
            DashboardNavDetails(
                name = "Attendance",
                icon = Icons.Filled.Rule,
            ),
            DashboardNavDetails(
                name = "Performance Report",
                icon = Icons.Filled.ChromeReaderMode,
            ),
            DashboardNavDetails(
                name = "Course Work",
                icon = Icons.Filled.Book,
            ),
            DashboardNavDetails(
                name = "Time Table",
                icon = Icons.Filled.CalendarMonth,
            ),
            DashboardNavDetails(
                name = "Placements",
                icon = Icons.Filled.SupervisedUserCircle,
            ),
            DashboardNavDetails(
                name = "Exam Form",
                icon = Icons.Filled.Description,
            ),
            DashboardNavDetails(
                name = "Exam Fee",
                icon = Icons.Filled.Payments,
            ),
            DashboardNavDetails(
                name = "Feedback",
                icon = Icons.Filled.RateReview,
            ),
        )

        return studentDashboardItems
    }

    fun getTeacherDashboardItems(): List<DashboardNavDetails> {
        val teacherDashboardItemsList = listOf<DashboardNavDetails>(
            DashboardNavDetails(
                name = "Attendance",
                icon = Icons.Filled.Rule,
            ),
            DashboardNavDetails(
                name = "Performance Report",
                icon = Icons.Filled.ChromeReaderMode,
            ),
            DashboardNavDetails(
                name = "Course Work",
                icon = Icons.Filled.Book,
            ),
            DashboardNavDetails(
                name = "Time Table",
                icon = Icons.Filled.CalendarMonth,
            ),
            DashboardNavDetails(
                name = "Placements",
                icon = Icons.Filled.SupervisedUserCircle,
            ),
            DashboardNavDetails(
                name = "Exam Form",
                icon = Icons.Filled.Description,
            ),
            DashboardNavDetails(
                name = "Feedback",
                icon = Icons.Filled.RateReview,
            ),
            DashboardNavDetails(
                name = "Profile",
                icon = Icons.Filled.Person,
            ),
        )

        return teacherDashboardItemsList
    }
}
