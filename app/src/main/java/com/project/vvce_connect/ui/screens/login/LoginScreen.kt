package com.project.vvce_connect.ui.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.vvce_connect.R
import com.project.vvce_connect.ui.screens.components.*

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ImageComponent(painter = painterResource(id = R.drawable.vvce_logo), content = "VVCE logo", modifier = Modifier)
        Spacer(modifier = Modifier.padding(16.dp))
        TextComponent(text = "Login", modifier = Modifier, style = TextStyle(fontSize = MaterialTheme.typography.h3.fontSize, fontWeight = FontWeight.Bold))
        Spacer(modifier = Modifier.padding(20.dp))
        TextFieldComponent(label = "Username")
        PasswordFieldComponent(label = "Password")
        Spacer(modifier = Modifier.padding(20.dp))
        ButtonComponent(text = "Login")
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
