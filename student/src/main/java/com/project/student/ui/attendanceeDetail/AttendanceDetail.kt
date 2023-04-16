package com.project.student.ui.attendanceeDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.tehras.charts.piechart.PieChart
import com.github.tehras.charts.piechart.PieChartData
import com.github.tehras.charts.piechart.animation.simpleChartAnimation
import com.github.tehras.charts.piechart.renderer.SimpleSliceDrawer
import com.project.navigator.ComposeNavigator
import com.project.student.ui.components.CardAttendance
import com.project.student.ui.components.DisplayNumberBox
import com.project.student.ui.theme.Purple500

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
                    PieChartData.Slice(attended.toFloat(), Color(0xFF77DD77)),
                    PieChartData.Slice(missed.toFloat(), Color(0xFFFF6961)),
                ),
            ),
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .verticalScroll(rememberScrollState()),
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 0.dp,
                bottomStart = 40.dp,
                bottomEnd = 40.dp,
            ),
            backgroundColor = Purple500,
        ) {
            Text(
                text = subjectTitle,
                modifier = Modifier.padding(20.dp),
                style = TextStyle(
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                ),
            )
        }
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
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .background(color = Purple500, shape = RoundedCornerShape(10.dp)),
            title = "Total Working Days",
            number = "${attended.toInt() + missed.toInt()}",
            color = Color.Unspecified,
        )
        Row(modifier = Modifier.fillMaxWidth().padding(24.dp)) {
            CardAttendance(
                modifier = Modifier,
                type = "Present",
                attendance = attended,
                color = Color(0xFF77DD77),
            )
            CardAttendance(
                modifier = Modifier,
                type = "Absent",
                attendance = missed,
                color = Color(0xFFFF6961),
            )
        }
    }
}
