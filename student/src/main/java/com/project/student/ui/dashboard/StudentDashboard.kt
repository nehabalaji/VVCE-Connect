package com.project.student.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.project.student.localdata.DashboardNavData
import com.project.student.ui.components.BottomNavigationBar
import com.project.student.ui.components.FeaturesGridComponent
import com.project.student.ui.components.ScaffoldComponent
import com.project.student.ui.components.TopAppBarComponent

@Composable
fun StudentDashboard() {
    ScaffoldComponent(
        modifier = Modifier,
        content = {
            TopAppBarComponent(
                modifier = Modifier,
                title = "Hi, Neha!"
            )
            FeaturesGridComponent(
                gridSize = 2,
                items = DashboardNavData.getStudentDashboardItems(),
                modifier = Modifier.background(Color.White)
            )
        },
        bottomBar = {
            BottomNavigationBar(
                items = DashboardNavData.getBottomNavItems(),
                modifier = Modifier.background(Color.White)
            )
        }
    )
}

@Preview
@Composable
fun StudentDashboardPreview() {
    StudentDashboard()
}
