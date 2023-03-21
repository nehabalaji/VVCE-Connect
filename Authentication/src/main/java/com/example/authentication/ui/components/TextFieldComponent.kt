package com.example.authentication.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextFieldComponent(
    label: String,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(start = 8.dp, end = 8.dp),
    onValueChanged: (String) -> Unit = {},
    error: Boolean = false,
    errorMessage: String = "Invalid value"
) {
    var text by rememberSaveable() {
        mutableStateOf("")
    }
    val focusManager = LocalFocusManager.current
    Column {
        OutlinedTextField(
            value = text,
            maxLines = 1,
            onValueChange = {
                text = it
                onValueChanged(it)
            },
            label = { Text(label) },
            modifier = modifier,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            ),
            trailingIcon = {
                val image = if (error) {
                    Icons.Default.Error
                } else {
                    null
                }
                if (image != null) {
                    Icon(imageVector = image, contentDescription = "error")
                }
            },
            isError = error
        )
        if (error) {
            TextComponent(
                text = errorMessage,
                style = TextStyle(color = Color.Red, fontSize = 12.sp),
                modifier = modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TextFieldComponentPreview() {
    TextFieldComponent("Username")
}
