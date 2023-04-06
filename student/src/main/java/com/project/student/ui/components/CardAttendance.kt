package com.project.student.ui.components


import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardAttendance(modifier: Modifier, type: String, attendance: String, color: Color) {
    Card(
        modifier = modifier
            .padding(10.dp)
            .height(172.dp)
            .width(150.dp),
        elevation = 10.dp,
        backgroundColor = color
    ) {
        Column() {
            TextComponent(text = type, modifier = Modifier, style = TextStyle(fontSize = 36.sp, textAlign = TextAlign.Center))
            Spacer(modifier = modifier.padding(24.dp))
            TextComponent(text = attendance, modifier = Modifier, style = TextStyle(fontSize = 48.sp, color = Color.White))
        }
    }
}

@Preview
@Composable
fun CardAttendancePreview() {
    CardAttendance(modifier = Modifier, type = "Present", attendance = "03", color = Color.Green)
}