package com.project.student.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopAppBarComponent(modifier: Modifier, title: String) {
    TextComponent(
        text = title,
        modifier = modifier.padding(10.dp),
        style = TextStyle(
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
    )
}

@Preview
@Composable
fun TopAppBarComponentPreview() {
    TopAppBarComponent(modifier = Modifier, title = "Hello Neha")
}
