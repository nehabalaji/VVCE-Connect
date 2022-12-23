package com.project.vvce_connect.ui.screens.registration.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.w3c.dom.Text

@Composable
fun TextComponent(text: String, modifier: Modifier,style :TextStyle) {
    Text(
        text = text,
        modifier.padding(vertical = 8.dp),
        style = style
    )
}

@Preview(showBackground = true)
@Composable
fun TextComponentPreview() {
    TextComponent(text = "Registration", modifier = Modifier, style = TextStyle(fontSize = MaterialTheme.typography.h3.fontSize, fontWeight = FontWeight.Bold))
}
