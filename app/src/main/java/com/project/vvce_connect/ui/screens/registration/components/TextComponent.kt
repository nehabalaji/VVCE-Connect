package com.project.vvce_connect.ui.screens.registration.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class TextComponent {
    @Composable
    fun TextComponent() {
        Text(text = "Registration",
            modifier = Modifier.padding(vertical = 8.dp))
    }

    @Preview(showBackground = true)
    @Composable
    fun TextComponentPreview() {
        TextComponent()
    }
}

