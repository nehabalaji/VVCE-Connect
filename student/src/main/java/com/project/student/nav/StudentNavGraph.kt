package com.project.student.nav

import android.content.Context
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.project.student.ui.dashboard.StudentDashboard
import com.project.navigator.ComposeNavigator
import com.project.navigator.Routes
import com.project.navigator.Screens
import com.project.student.ui.attendance.AttendanceScreen
import com.project.student.ui.courseWork.CourseWorkScreen
import com.project.student.ui.examFee.ExamFeeScreen
import com.project.student.ui.examForm.ExamFormScreen
import com.project.student.ui.feedback.FeedbackScreen
import com.project.student.ui.performanceReport.PerformanceReportScreen
import com.project.student.ui.placements.PlacementsScreen
import com.project.student.ui.timetable.TimetableScreen

fun NavGraphBuilder.studentNavGraph(composeNavigator: ComposeNavigator, context: Context) {
    navigation(
        startDestination = Screens.StudentDashboardScreen.route,
        route = Routes.OnBoarding.name
    ) {
        composable(Screens.StudentDashboardScreen.name) {
            StudentDashboard(composeNavigator)
        }
        composable(Screens.StudentAttendance.name) {
            AttendanceScreen()
        }
        composable(Screens.StudentPerformanceReport.name) {
            PerformanceReportScreen()
        }
        composable(Screens.StudentCourseWork.name) {
            CourseWorkScreen()
        }
        composable(Screens.StudentTimeTable.name) {
            TimetableScreen()
        }
        composable(Screens.StudentPlacements.name) {
            PlacementsScreen()
        }
        composable(Screens.StudentExamForm.name) {
            ExamFormScreen()
        }
        composable(Screens.StudentExamFee.name) {
            ExamFeeScreen()
        }
        composable(Screens.StudentFeedback.name) {
            FeedbackScreen()
        }
    }
}