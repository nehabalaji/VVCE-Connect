package com.project.student.nav

import android.content.Context
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.project.navigator.ComposeNavigator
import com.project.navigator.Routes
import com.project.navigator.Screens
import com.project.student.ui.attendance.AttendanceScreen
import com.project.student.ui.attendanceeDetail.AttendanceDetail
import com.project.student.ui.courseWork.CourseWorkDetails
import com.project.student.ui.courseWork.CourseWorkScreen
import com.project.student.ui.dashboard.StudentDashboard
import com.project.student.ui.examForm.ExamFormScreen
import com.project.student.ui.feedback.FeedbackScreen
import com.project.student.ui.performanceReport.PerformanceReportDetailScreen
import com.project.student.ui.performanceReport.PerformanceReportScreen
import com.project.student.ui.placements.PlacementsScreen
import com.project.student.ui.settings.SettingsScreen
import com.project.student.ui.timetable.TimetableScreen

fun NavGraphBuilder.studentNavGraph(composeNavigator: ComposeNavigator, context: Context) {
    navigation(
        startDestination = Screens.StudentDashboardScreen.route,
        route = Routes.OnBoarding.name
    ) {
        composable(Screens.StudentDashboardScreen.name) {
            StudentDashboard(composeNavigator, context)
        }
        composable(Screens.StudentAttendance.name) {
            AttendanceScreen(composeNavigator)
        }
        composable(Screens.StudentAttendanceDetail.name) {
            val subjectTitle = it.arguments?.getString("subject_title") ?: ""
            val subjectCode = it.arguments?.getString("subject_code") ?: ""
            val missed = it.arguments?.getString("missed") ?: ""
            val attended = it.arguments?.getString("attended") ?: ""

            AttendanceDetail(composeNavigator, subjectCode, subjectTitle, attended, missed)
        }
        composable(Screens.StudentPerformanceReport.name) {
            PerformanceReportScreen(composeNavigator)
        }
        composable(Screens.StudentPerformanceReportDetails.name) {
            val subject = it.arguments?.getString("subject_title") ?: ""

            PerformanceReportDetailScreen(subjectTitle = subject)
        }
        composable(Screens.StudentCourseWork.name) {
            CourseWorkScreen(composeNavigator)
        }
        composable(Screens.StudentCourseWorkDetails.name) {
            val subject = it.arguments?.getString("subject_id") ?: ""

            CourseWorkDetails(subject)
        }
        composable(Screens.StudentTimeTable.name) {
            TimetableScreen(context)
        }
        composable(Screens.StudentPlacements.name) {
            PlacementsScreen()
        }
        composable(Screens.StudentExamForm.name) {
            ExamFormScreen()
        }
        composable(Screens.Settings.name) {
            SettingsScreen()
        }
        composable(Screens.StudentFeedback.name) {
            FeedbackScreen()
        }
    }
}
