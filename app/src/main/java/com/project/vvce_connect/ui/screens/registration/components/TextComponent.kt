package com.project.vvce_connect.ui.screens.registration.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TextComponent(text:String) {
    Text(text = text,
        modifier = Modifier.padding(vertical = 8.dp),
        fontSize = 36.sp,
        style = TextStyle(
            fontWeight = FontWeight.Bold
        )
    )
}

@Preview(showBackground = true)
@Composable
fun TextComponentPreview() {
    TextComponent(text = "Registration")
}

