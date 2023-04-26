package com.project.student.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PasswordFieldComponent(
    label: String,
    modifier: Modifier = Modifier
        .padding(horizontal = 8.dp, vertical = 4.dp)
) {
    var password by rememberSaveable() {
        mutableStateOf("")
    }
    var passwordVisible by rememberSaveable() {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text(text = label) },
        singleLine = true,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (passwordVisible) {
                Icons.Filled.Visibility
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
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PasswordFieldComponentPreview() {
    PasswordFieldComponent("Password")
}
