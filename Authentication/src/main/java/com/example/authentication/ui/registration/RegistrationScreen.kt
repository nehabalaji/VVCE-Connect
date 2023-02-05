package com.example.authentication.ui.registration

import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.authentication.ui.components.*
import com.example.authentication.R

@Composable
fun RegistrationScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ImageComponent(painter = painterResource(id = R.drawable.vvce_logo), "Logo of VVCE")
        TextComponent("Registration", modifier = Modifier, style = TextStyle(fontSize = MaterialTheme.typography.h3.fontSize, fontWeight = FontWeight.Bold))
        Spacer(modifier = Modifier.padding(20.dp))
        TextFieldComponent("Enter USN")
        TextFieldComponent("Enter Email id")
        PasswordFieldComponent("Enter Password")
        PasswordFieldComponent("Confirm Password")
        Spacer(modifier = Modifier.padding(10.dp))
        ButtonComponent("REGISTER")
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationScreenPreview() {
    RegistrationScreen()
}
