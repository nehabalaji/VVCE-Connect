package com.project.vvce_connect.ui.screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
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
            Text(text = type, textAlign = TextAlign.Center, fontSize = 36.sp)
            Spacer(modifier = modifier.padding(24.dp))
            Text(text = attendance, textAlign = TextAlign.End, fontSize = 48.sp, style = TextStyle(color = Color.White))
        }
    }
}

@Preview
@Composable
fun CardAttendancePreview() {
    CardAttendance(modifier = Modifier, type = "Present", attendance = "03", color = Color.Green)
}
