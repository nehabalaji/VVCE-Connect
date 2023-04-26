package com.project.student.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DisplayNumberBox(modifier: Modifier, title: String, number: String, color: Color) {
    Row(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        TextComponent(text = title, modifier = Modifier, style = TextStyle(fontSize = 24.sp))
        TextComponent(text = number, modifier = Modifier, style = TextStyle(fontSize = 24.sp))
    }
}

@Preview(showBackground = true)
@Composable
fun DisplayNumberBoxPreview() {
    DisplayNumberBox(modifier = Modifier, title = "Days attended", number = "24", color = Color.Unspecified)
}
