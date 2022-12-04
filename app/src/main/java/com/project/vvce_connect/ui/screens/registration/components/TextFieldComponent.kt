package com.project.vvce_connect.ui.screens.registration.components

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

class TextFieldComponent {
    @Composable
    fun TextFieldComponent() {
        var text by remember {
            mutableStateOf("")
        }
        OutlinedTextField(value = text,
            onValueChange ={ text = it},
            label = {
                Text(text = "Username")
            })

    }

    @Preview(showBackground = true)
    @Composable
    fun TextFieldComponentPreview() {
        TextFieldComponent()
    }
}