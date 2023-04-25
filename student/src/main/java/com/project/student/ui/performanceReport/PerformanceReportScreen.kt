package com.project.student.ui.performanceReport

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.navigator.ComposeNavigator
import com.project.navigator.Screens
import com.project.student.ui.components.IconButtonComponent
import com.project.student.ui.performanceReport.viewmodel.PerformanceReportViewModel
import com.project.student.ui.theme.Purple500

@Composable
fun PerformanceReportScreen(
    composeNavigator: ComposeNavigator,
    performanceReportViewModel: PerformanceReportViewModel = hiltViewModel(),
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
                    bottomEnd = 40.dp,
                ),
                backgroundColor = Purple500,
            ) {
                Text(
                    text = "Performance report",
                    modifier = Modifier.padding(20.dp),
                    style = TextStyle(
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                    ),
                )
            }
        }

        items(courseListItems) {
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .clickable {
                        composeNavigator.navigate(Screens.StudentPerformanceReportDetails.route.plus("/$it"))
                    },
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = it,
                    modifier = Modifier.padding(16.dp).weight(0.75f).clickable {
                        composeNavigator.navigate(Screens.StudentPerformanceReportDetails.route.plus("/$it"))
                    },
                    style = TextStyle(fontSize = 24.sp),
                )
                IconButtonComponent(icon = Icons.Filled.ArrowForwardIos, content = "Right Arrow")
            }
            Spacer(modifier = Modifier
                .height(2.dp)
                .fillMaxWidth()
                .background(color = Color.Black)
                .padding(2.dp)
            )
        }
    }
}
