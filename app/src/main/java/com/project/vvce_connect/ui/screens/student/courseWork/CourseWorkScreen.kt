package com.project.vvce_connect.ui.screens.student.courseWork

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.project.vvce_connect.ui.screens.components.*
import com.project.vvce_connect.ui.screens.localdata.CourseWorkData
import com.project.vvce_connect.ui.screens.localdata.DashboardNavData

@Composable
fun CourseWorkScreen(modifier: Modifier, title: String, subject: String) {
    ScaffoldComponent(
        modifier = modifier,
        content = {
            BoxInBox(
                modifier = modifier,
                text = title,
                subject = subject,
            )
            CourseWorkGrid(coursework = CourseWorkData.getCourseWork(), modifier = modifier)
        },
        bottomBar = {
            BottomNavigationBar(
                items = DashboardNavData.getBottomNavItems(),
                modifier = modifier,
            )
        },
    )
}

@Preview
@Composable
fun CourseWorkScreenPreview() {
    CourseWorkScreen(modifier = Modifier, title = "Course Work", subject = "Computer Network")
}
