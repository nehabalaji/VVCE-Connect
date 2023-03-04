package com.example.authentication.ui.registration

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.authentication.ui.components.*
import com.example.authentication.ui.theme.Purple500
import com.example.authentication.ui.theme.Purple700

@Composable
fun RegistrationScreen() {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 0.dp,
                bottomStart = 40.dp,
                bottomEnd = 40.dp
            )
        ) {
            Image(
                painter = painterResource(id = com.example.authentication.R.drawable.vvce_connect_banner),
                contentDescription = "VVCE Banner",
                alignment = Alignment.Center,
                modifier = Modifier
                    .background(Purple500)
                    .padding(10.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextComponent("REGISTER", modifier = Modifier, style = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Purple700))
            TextFieldComponent("Name")
            TextFieldComponent("Phone")
            TextFieldComponent("USN")
            TextFieldComponent("Email id")
            TextFieldComponent("Year of Joining")
            PasswordFieldComponent("Password")
            PasswordFieldComponent("Confirm Password")
            Spacer(modifier = Modifier.padding(10.dp))
            ButtonComponent("REGISTER")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationScreenPreview() {
    RegistrationScreen()
}
