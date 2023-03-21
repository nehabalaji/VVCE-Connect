package com.example.authentication.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PasswordFieldComponent(
    label: String,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(start = 8.dp, end = 8.dp),
    onValueChanged: (String) -> Unit = {},
    error: Boolean = false,
    errorMessage: String = "Invalid value",
    imeAction: ImeAction = ImeAction.Default,
    onActionDone: KeyboardActionScope.() -> Unit = {}
) {
    val focusManager = LocalFocusManager.current
    var password by rememberSaveable() {
        mutableStateOf("")
    }
    var passwordVisible by rememberSaveable() {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = password,
        onValueChange = {
            password = it
            onValueChanged(it)
        },
        label = { Text(text = label) },
        singleLine = true,
        isError = error,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Down) },
            onDone = onActionDone
        ),
        maxLines = 1,
        trailingIcon = {
            val image = if (passwordVisible) {
                Icons.Filled.Visibility
            } else if (error) {
                Icons.Default.Error
            } else {
                Icons.Filled.VisibilityOff
            }

            val description = if (passwordVisible) {
                "Hide Password"
            } else {
                "Show Password"
            }
            IconButton(onClick = {
                passwordVisible = !passwordVisible
            }) {
                Icon(imageVector = image, contentDescription = description)
            }
        },
        modifier = modifier
    )
    if (error) {
        TextComponent(
            text = errorMessage,
            style = TextStyle(color = Color.Red, fontSize = 12.sp),
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PasswordFieldComponentPreview() {
    PasswordFieldComponent("Password")
}
