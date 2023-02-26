package com.project.vvce_connect.ui.screens.components

import androidx.compose.foundation.layout.padding
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
