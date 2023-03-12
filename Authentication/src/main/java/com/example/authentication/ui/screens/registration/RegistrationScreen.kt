package com.example.authentication.ui.screens.registration

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.authentication.ui.components.*
import com.example.authentication.ui.screens.registration.viewmodel.RegistrationViewModel
import com.example.authentication.ui.theme.Purple500
import com.example.authentication.ui.theme.Purple700
import com.project.navigator.Screens

@Composable
fun RegistrationScreen(
    navController: NavController
) {
    val registrationViewModel: RegistrationViewModel = hiltViewModel()
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
            TextComponent("Sign Up", modifier = Modifier, style = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Purple700))
            TextFieldComponent("Name", onValueChanged = {
                registrationViewModel.setName(it)
            })
            TextFieldComponent("Phone", onValueChanged = {
                registrationViewModel.setPhoneNumber(it)
            })
            TextFieldComponent("USN", onValueChanged = {
                registrationViewModel.setUsn(it)
            })
            TextFieldComponent("Email id", onValueChanged = {
                registrationViewModel.setEmail(it)
            })
            TextFieldComponent("Year of Joining", onValueChanged = {
                registrationViewModel.setYearOfJoining(it)
            })
            PasswordFieldComponent("Password", onValueChanged = {
                registrationViewModel.setPassword(it)
            })
            PasswordFieldComponent("Confirm Password", onValueChanged = {
                registrationViewModel.setConfirmedPassword(it)
            })
            Spacer(modifier = Modifier.padding(10.dp))
            ButtonComponent("REGISTER") {
                navController.navigate(Screens.EmailVerificationScreen.name)
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    "Have an account? Login",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal, color = Purple700)
                )
                IconButton(onClick = {
                    navController.navigate(Screens.LoginScreen.route)
                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Next Button",
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}

// @Preview(showBackground = true)
// @Composable
// fun RegistrationScreenPreview() {
//    RegistrationScreen()
// }
