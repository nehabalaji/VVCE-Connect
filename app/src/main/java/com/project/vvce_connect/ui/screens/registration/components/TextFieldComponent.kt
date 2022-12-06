package com.project.vvce_connect.ui.screens.registration.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun TextFieldComponent(label:String,modifier: Modifier = Modifier
    .padding(horizontal = 8.dp)
    .padding(4.dp)) {
    var text by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = text,
        onValueChange ={ text = it},
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth(0.8f)
    )

}

@Preview(showBackground = true)
@Composable
fun TextFieldComponentPreview() {
    TextFieldComponent("Username")
}
