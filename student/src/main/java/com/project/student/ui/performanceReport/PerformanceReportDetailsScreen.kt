package com.project.student.ui.performanceReport

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.tehras.charts.bar.BarChart
import com.github.tehras.charts.bar.BarChartData
import com.github.tehras.charts.bar.renderer.bar.SimpleBarDrawer
import com.github.tehras.charts.bar.renderer.label.SimpleValueDrawer
import com.github.tehras.charts.bar.renderer.xaxis.SimpleXAxisDrawer
import com.github.tehras.charts.bar.renderer.yaxis.SimpleYAxisDrawer
import com.github.tehras.charts.piechart.animation.simpleChartAnimation
import com.project.student.ui.components.DisplayNumberBox
import com.project.student.ui.performanceReport.viewmodel.PerformanceReportViewModel
import com.project.student.ui.theme.Purple500

@Composable
fun PerformanceReportDetailScreen(
    subjectTitle: String,
    performanceReportViewModel: PerformanceReportViewModel = hiltViewModel()
) {
    Log.v("TAG", subjectTitle)
    val ia1 = performanceReportViewModel.ia1Marks.collectAsState()
    val ia1Marks = ia1.value.collectAsState(initial = "0")

    val ia2 = performanceReportViewModel.ia2Marks.collectAsState()
    val ia2Marks = ia2.value.collectAsState(initial = "0")

    val ia3 = performanceReportViewModel.ia3Marks.collectAsState()
    val ia3Marks = ia3.value.collectAsState(initial = "0")

    val quiz = performanceReportViewModel.quizMarks.collectAsState()
    val quizMarks = quiz.value.collectAsState(initial = "0")

    performanceReportViewModel.getIaMarksForSubject(subjectTitle)

    Log.v("TAG", ia1Marks.value+" "+ia2Marks.value+" "+ia3Marks.value)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(subjectTitle)
        Box(
            modifier = Modifier
                .padding(top = 60.dp, start = 24.dp, end = 24.dp)
                .height(300.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            BarChart(
                barChartData = BarChartData(
                    bars = listOf(
                        BarChartData.Bar(ia1Marks.value.toInt().toFloat(), Purple500, "IA 1"),
                        BarChartData.Bar(ia2Marks.value.toInt().toFloat(), Purple500, "IA 2"),
                        BarChartData.Bar(ia3Marks.value.toInt().toFloat(), Purple500, "IA 3"),
                    )
                ),
                modifier = Modifier.fillMaxSize(),
                animation = simpleChartAnimation(),
                barDrawer = SimpleBarDrawer(),
                xAxisDrawer = SimpleXAxisDrawer(),
                yAxisDrawer = SimpleYAxisDrawer(),
                labelDrawer = SimpleValueDrawer()
            )
        }
        DisplayNumberBox(
            modifier = Modifier,
            title = "CIE 1",
            number = ia1Marks.value,
            color = Color.LightGray
        )
        DisplayNumberBox(
            modifier = Modifier,
            title = "CIE 2",
            number = ia2Marks.value,
            color = Color.LightGray
        )
        DisplayNumberBox(
            modifier = Modifier,
            title = "CIE 3",
            number = ia3Marks.value,
            color = Color.LightGray
        )
        DisplayNumberBox(
            modifier = Modifier,
            title = "Quiz/Assignments",
            number = quizMarks.value,
            color = Color.LightGray
        )
    }
}
