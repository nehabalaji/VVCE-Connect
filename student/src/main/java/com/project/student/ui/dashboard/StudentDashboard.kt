package com.project.student.ui.dashboard

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.navigator.ComposeNavigator
import com.project.student.localdata.DashboardNavData
import com.project.student.ui.HomeScreen
import com.project.student.ui.components.BottomNavigationBar
import com.project.student.ui.components.ScaffoldComponent
import com.project.student.ui.components.TopAppBarComponent
import com.project.student.ui.dashboard.viewmodel.StudentDashboardViewModel
import com.project.student.ui.notification.NotificationScreen
import com.project.student.ui.profile.StudentProfileScreen

@Composable
fun StudentDashboard(
    composeNavigator: ComposeNavigator,
    context: Context,
    studentDashboardViewModel: StudentDashboardViewModel = hiltViewModel()
) {
    val screens by studentDashboardViewModel.screen.collectAsState()
    val screen by screens.collectAsState(initial = "Home")

    ScaffoldComponent(
        modifier = Modifier,
        topBar = {
            TopAppBarComponent(
                modifier = Modifier,
                title = "Hi, Neha!"
            )
        },
        content = {
            when (screen) {
                "Home" -> HomeScreen(composeNavigator)
                "Notification" -> NotificationScreen()
                "Profile" -> StudentProfileScreen()
            }
        },
        bottomBar = {
            BottomNavigationBar(
                items = DashboardNavData.getBottomNavItems(),
                modifier = Modifier.background(Color.White),
                composeNavigator,
                studentDashboardViewModel,
                context
            )
        }
    )
}
