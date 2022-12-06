package com.project.vvce_connect.ui.screens.registration

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.vvce_connect.ui.screens.registration.components.*

class RegistrationScreen{



    @Composable
    fun RegistrationScreen() {
            ImageComponent()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                ImageComponent()
                TextComponent("Registration")
                Spacer(modifier = Modifier.padding(20.dp))
                TextFieldComponent("Enter USN")
                TextFieldComponent("Enter Email id")
                PasswordFieldComponent("Enter Password")
                PasswordFieldComponent("Confirm Password")
                Spacer(modifier = Modifier.padding(10.dp))
                ButtonComponent("REGISTER")
            }
        }



    @Preview
    @Composable
    fun RegistrationScreenPreview() {
        RegistrationScreen()
    }
}
