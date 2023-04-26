package com.project.student.localdata

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import com.project.navigator.Screens

object DashboardNavData {
    fun getBottomNavItems(): List<DashboardNavDetails> {
        return listOf(
            DashboardNavDetails(
                name = "Home",
                icon = Icons.Filled.Home,
                screen = "Home"
            ),
            DashboardNavDetails(
                name = "Announcements",
                icon = Icons.Filled.Notifications,
                screen = "Notification"
            ),
            DashboardNavDetails(
                name = "About Us",
                icon = Icons.Filled.Info,
                screen = "About Us"
            ),
            DashboardNavDetails(
                name = "Profile",
                icon = Icons.Filled.Person,
                screen = "Profile"
            )
        )
    }

    fun getStudentDashboardItems(): List<DashboardNavDetails> {
        return listOf(
            DashboardNavDetails(
                name = "Attendance",
                icon = Icons.Filled.Rule,
                screen = Screens.StudentAttendance.route
            ),
            DashboardNavDetails(
                name = "Performance Report",
                icon = Icons.Filled.ChromeReaderMode,
                screen = Screens.StudentPerformanceReport.name
            ),
            DashboardNavDetails(
                name = "Course Work",
                icon = Icons.Filled.Book,
                screen = Screens.StudentCourseWork.route
            ),
            DashboardNavDetails(
                name = "Time Table",
                icon = Icons.Filled.CalendarMonth,
                screen = Screens.StudentTimeTable.route
            ),
            DashboardNavDetails(
                name = "Placements",
                icon = Icons.Filled.SupervisedUserCircle,
                screen = Screens.StudentPlacements.route
            ),
            DashboardNavDetails(
                name = "Exam Form",
                icon = Icons.Filled.Description,
                screen = Screens.StudentExamForm.route
            ),
            DashboardNavDetails(
                name = "Feedback",
                icon = Icons.Filled.RateReview,
                screen = Screens.StudentFeedback.route
            )
//            DashboardNavDetails(
//                name = "Settings",
//                icon = Icons.Filled.Settings,
//                screen = Screens.Settings.route
//            )
        )
    }

    fun getTeacherDashboardItems(): List<DashboardNavDetails> {
        return listOf(
            DashboardNavDetails(
                name = "Attendance",
                icon = Icons.Filled.Rule
            ),
            DashboardNavDetails(
                name = "Performance Report",
                icon = Icons.Filled.ChromeReaderMode
            ),
            DashboardNavDetails(
                name = "Course Work",
                icon = Icons.Filled.Book
            ),
            DashboardNavDetails(
                name = "Time Table",
                icon = Icons.Filled.CalendarMonth
            ),
            DashboardNavDetails(
                name = "Placements",
                icon = Icons.Filled.SupervisedUserCircle
            ),
            DashboardNavDetails(
                name = "Exam Form",
                icon = Icons.Filled.Description
            ),
            DashboardNavDetails(
                name = "Feedback",
                icon = Icons.Filled.RateReview
            ),
            DashboardNavDetails(
                name = "Profile",
                icon = Icons.Filled.Person
            )
        )
    }
}
