package com.project.vvce_connect.ui.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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
        Row(modifier = modifier.padding(16.dp).fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            TextComponent(text = title, modifier = Modifier, style = TextStyle(fontSize = 24.sp))
            Spacer(modifier = modifier.padding(end = 48.dp, start = 48.dp))
            Box(
                modifier = Modifier.align(Alignment.CenterVertically),
                contentAlignment = Alignment.CenterEnd
            ){
                TextComponent(text = number, modifier = Modifier, style = TextStyle(fontSize = 24.sp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DisplayNumberBoxPreview() {
    DisplayNumberBox(modifier = Modifier, title = "Days attended", number = "24", color = Color.Unspecified)
}
