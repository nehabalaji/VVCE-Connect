package com.project.student.ui.performanceReport

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.project.student.ui.components.BoxInBox
import com.project.student.ui.components.DisplayNumberBox
import com.project.student.ui.components.IconImageComponent

@Composable
fun PerformanceReportScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        BoxInBox(modifier = Modifier, text = "Performance Report", subject = "Operating Systems")
        Box(
            modifier = Modifier
                .padding(top = 36.dp, start = 24.dp, end = 24.dp)
                .height(300.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            IconImageComponent(
                modifier = Modifier.size(248.dp),
                image = Icons.Filled.BarChart,
                content = "Bar Chart"
            )
        }
        DisplayNumberBox(modifier = Modifier, title = "CIE 1", number = "25", color = Color.LightGray)
        DisplayNumberBox(modifier = Modifier, title = "CIE 2", number = "21", color = Color.LightGray)
        DisplayNumberBox(modifier = Modifier, title = "CIE 3", number = "28", color = Color.LightGray)
    }
}
