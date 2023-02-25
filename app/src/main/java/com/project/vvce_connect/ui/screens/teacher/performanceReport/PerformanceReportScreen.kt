package com.project.vvce_connect.ui.screens.teacher.performanceReport

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.vvce_connect.ui.screens.components.BoxInBox
import com.project.vvce_connect.ui.screens.components.DisplayNumberBox

@Composable
fun PerformanceReportScreen(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        BoxInBox(modifier = modifier, text = "Performance Report", subject = "Operating Systems")
        Box(
            modifier = modifier
                .padding(top = 36.dp, start = 24.dp, end = 24.dp)
                .height(300.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Image(
                imageVector = Icons.Filled.BarChart,
                contentDescription = "Pie",
                modifier = modifier.size(248.dp)
            )
        }
        DisplayNumberBox(modifier = modifier, title = "CIE 1                   ", number = "25", color = Color.LightGray)
        DisplayNumberBox(modifier = modifier, title = "CIE 2                   ", number = "21", color = Color.LightGray)
        DisplayNumberBox(modifier = modifier, title = "CIE 3                   ", number = "28", color = Color.LightGray)
    }
}

@Preview(showBackground = true)
@Composable
fun PerformanceReportScreenPreview() {
    PerformanceReportScreen(modifier = Modifier)
}
