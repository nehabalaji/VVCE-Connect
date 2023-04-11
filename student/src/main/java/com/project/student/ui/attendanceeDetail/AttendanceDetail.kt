package com.project.student.ui.attendanceeDetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.tehras.charts.piechart.PieChart
import com.github.tehras.charts.piechart.PieChartData
import com.github.tehras.charts.piechart.animation.simpleChartAnimation
import com.github.tehras.charts.piechart.renderer.SimpleSliceDrawer
import com.project.navigator.ComposeNavigator
import com.project.student.ui.components.CardAttendance
import com.project.student.ui.components.DisplayNumberBox

@Composable
fun AttendanceDetail(
    composeNavigator: ComposeNavigator,
    subjectCode: String,
    subjectTitle: String,
    attended: String,
    missed: String,
) {
    val pieChartData = remember {
        mutableStateOf(
            PieChartData(
                listOf(
                    PieChartData.Slice(attended.toFloat(), Color.Green),
                    PieChartData.Slice(missed.toFloat(), Color.Red),
                ),
            ),
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        Text(subjectTitle)
        Box(
            modifier = Modifier
                .padding(top = 60.dp, start = 24.dp, end = 24.dp)
                .height(300.dp)
                .align(Alignment.CenterHorizontally),
        ) {
            PieChart(
                pieChartData = pieChartData.value,
                modifier = Modifier.size(200.dp),
                animation = simpleChartAnimation(),
                sliceDrawer = SimpleSliceDrawer(),
            )
        }
        DisplayNumberBox(
            modifier = Modifier,
            title = "Total Working Days",
            number = "${attended.toInt() + missed.toInt()}",
            color = Color.Unspecified,
        )
        Row(modifier = Modifier.fillMaxWidth().padding(24.dp)) {
            CardAttendance(
                modifier = Modifier,
                type = "Present",
                attendance = attended,
                color = Color.Green,
            )
            CardAttendance(
                modifier = Modifier,
                type = "Absent",
                attendance = missed,
                color = Color.Red,
            )
        }
    }
}
