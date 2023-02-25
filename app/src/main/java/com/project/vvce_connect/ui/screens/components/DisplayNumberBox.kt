package com.project.vvce_connect.ui.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DisplayNumberBox(modifier: Modifier, title: String, number: String, color: Color) {
    Box(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(color = color)
    ) {
        Row(modifier = modifier.padding(16.dp)) {
            Text(text = title, fontSize = 24.sp)
            Spacer(modifier = modifier.padding(end = 48.dp, start = 48.dp))
            Text(text = number, fontSize = 24.sp)
        }
    }
}

@Preview
@Composable
fun DisplayNumberBoxPreview() {
    DisplayNumberBox(modifier = Modifier, title = "Total Working Days", number = "24", color = Color.Unspecified)
}
