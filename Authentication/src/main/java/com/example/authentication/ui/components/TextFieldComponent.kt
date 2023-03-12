package com.example.authentication.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldComponent(
    label: String,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(start = 8.dp, end = 8.dp),
    onValueChanged: (String) -> Unit = {},
    error: Boolean = false
) {
    var text by rememberSaveable() {
        mutableStateOf("")
    }
    Column {
        OutlinedTextField(
            value = text,
            trailingIcon = { if (error) Icons.Default.Error },
            onValueChange = {
                text = it
                onValueChanged(it)
            },
            label = { Text(label) },
            modifier = modifier,
            isError = error
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TextFieldComponentPreview() {
    TextFieldComponent("Username")
}
