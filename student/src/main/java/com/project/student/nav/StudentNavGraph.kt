package com.project.student.nav

import android.content.Context
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.project.student.ui.dashboard.StudentDashboard
import com.project.navigator.ComposeNavigator
import com.project.navigator.Routes
import com.project.navigator.Screens

fun NavGraphBuilder.studentNavGraph(composeNavigator: ComposeNavigator, context: Context) {
    navigation(
        startDestination = Screens.StudentDashboardScreen.route,
        route = Routes.OnBoarding.name
    ) {
        composable(Screens.StudentDashboardScreen.name) {
            StudentDashboard()
        }
    }
}