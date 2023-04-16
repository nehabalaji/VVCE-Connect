package com.project.student.ui.performanceReport

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.navigator.ComposeNavigator
import com.project.navigator.Screens
import com.project.student.ui.courseWork.viewmodel.CourseWorkViewModel
import com.project.student.ui.performanceReport.viewmodel.PerformanceReportViewModel

@Composable
fun PerformanceReportScreen(
    composeNavigator: ComposeNavigator,
    performanceReportViewModel: PerformanceReportViewModel = hiltViewModel()
) {
    val courseList by performanceReportViewModel.subjects.collectAsState()
    val courseListItems by courseList.collectAsState(initial = emptyList())

    LazyColumn() {
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomStart = 40.dp,
                    bottomEnd = 40.dp
                )
            ) {
                Text(text = "Performance report")
            }
        }

        items(courseListItems) {
            Text(
                text = it,
                modifier = Modifier.padding(16.dp).clickable {
                    composeNavigator.navigate(Screens.StudentPerformanceReportDetails.route.plus("/$it"))
                }
            )
        }
    }
}
