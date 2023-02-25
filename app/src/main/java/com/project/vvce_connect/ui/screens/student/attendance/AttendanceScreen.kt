package com.project.vvce_connect.ui.screens.student.attendance

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.vvce_connect.ui.screens.components.BoxInBox
import com.project.vvce_connect.ui.screens.components.CardAttendance
import com.project.vvce_connect.ui.screens.components.DisplayNumberBox

@Composable
fun AttendanceScreen(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        BoxInBox(modifier = Modifier, text = "Attendance", subject = "Cryptography")
        Box(
            modifier = modifier
                .padding(top = 36.dp, start = 24.dp, end = 24.dp)
                .height(300.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Image(
                imageVector = Icons.Filled.PieChart,
                contentDescription = "Pie",
                modifier = modifier.size(248.dp)
            )
        }
        DisplayNumberBox(modifier = modifier, title = "Total Working Days", number = "24", color = Color.Unspecified)
        Row(modifier = modifier.fillMaxWidth().padding(24.dp)) {
            CardAttendance(modifier = Modifier, type = "Present", attendance = "03", color = Color.Green)
            CardAttendance(modifier = Modifier, type = "Absent", attendance = "20", color = Color.Red)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AttendanceScreenPreview() {
    AttendanceScreen(modifier = Modifier)
}
