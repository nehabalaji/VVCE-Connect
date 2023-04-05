package com.project.authentication.ui.screens.login

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.Authentication.R
import com.project.authentication.ui.components.*
import com.project.authentication.ui.screens.login.viewmodel.LoginViewModel
import com.project.authentication.ui.theme.Purple500
import com.project.navigator.ComposeNavigator
import com.project.navigator.Screens

@Composable
fun LoginScreen(
    context: Context,
    composeNavigator: ComposeNavigator,
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    val emailError = remember {
        mutableStateOf(false)
    }
    val passwordError = remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
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
                painter = painterResource(id = R.drawable.vvce_connect_banner),
                contentDescription = "VVCE Banner",
                alignment = Alignment.Center,
                modifier = Modifier
                    .background(Purple500)
                    .padding(10.dp)
            )
        }
        ImageComponent(painter = painterResource(id = R.drawable.vvce_logo), content = "VVCE logo")
        Spacer(modifier = Modifier.padding(16.dp))
        TextComponent(text = "Login", modifier = Modifier, style = TextStyle(fontSize = MaterialTheme.typography.h3.fontSize, fontWeight = FontWeight.Bold))
        Spacer(modifier = Modifier.padding(20.dp))
        TextFieldComponent(label = "Username", onValueChanged = {
            loginViewModel.setEmail(it)
        }, error = emailError.value, errorMessage = "Enter a valid college email id")
        PasswordFieldComponent(
            label = "Password",
            onValueChanged = {
                loginViewModel.setPassword(it)
            },
            error = passwordError.value,
            errorMessage = "Enter a password with 8 or more characters",
            imeAction = ImeAction.Done,
            onActionDone = {
                emailError.value = !loginViewModel.validateEmailId()
                passwordError.value = !loginViewModel.validatePassword()
                loginViewModel.loginUser().addOnCompleteListener{
                    if (it.isSuccessful) {
                        composeNavigator.navigate(Screens.StudentDashboardScreen.route)
                    } else {
                        Toast.makeText(context, "Please check your credentials", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        )
        Spacer(modifier = Modifier.padding(20.dp))
        ButtonComponent(text = "Login", onClick = {
            emailError.value = !loginViewModel.validateEmailId()
            passwordError.value = !loginViewModel.validatePassword()
            loginViewModel.loginUser().addOnCompleteListener{
                if (it.isSuccessful) {
                    composeNavigator.navigate(Screens.StudentDashboardScreen.route)
                } else {
                    Toast.makeText(context, "Please check your credentials", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}

