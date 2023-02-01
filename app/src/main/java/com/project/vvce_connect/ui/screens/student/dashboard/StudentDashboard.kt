package com.project.vvce_connect.ui.screens.student.dashboard

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.project.vvce_connect.ui.screens.components.BottomNavigationBar
import com.project.vvce_connect.ui.screens.components.FeaturesGridComponent
import com.project.vvce_connect.ui.screens.components.ScaffoldComponent
import com.project.vvce_connect.ui.screens.components.TopAppBarComponent
import com.project.vvce_connect.ui.screens.localdata.DashboardNavData

@Composable
fun StudentDashboard() {
    ScaffoldComponent(
        modifier = Modifier,
        content = {
            TopAppBarComponent(
                modifier = Modifier,
                title = "Hi Neha"
            )
            FeaturesGridComponent(
                gridSize = 2,
                items = DashboardNavData.getStudentDashboardItems(),
                modifier = Modifier
            )
        },
        bottomBar = {
            BottomNavigationBar(
                items = DashboardNavData.getBottomNavItems(),
                modifier = Modifier
            )
        }
    )
}

@Preview
@Composable
fun StudentDashboardPreview() {
    StudentDashboard()
}
