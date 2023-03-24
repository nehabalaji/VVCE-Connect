package com.project.authentication.ui.screens.verification

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.Authentication.R
import com.project.authentication.ui.components.ButtonComponent
import com.project.authentication.ui.components.TextComponent
import com.project.authentication.ui.screens.verification.viewmodel.EmailVerificationViewModel
import com.project.authentication.ui.theme.Purple500
import com.project.navigator.ComposeNavigator

@Composable
fun EmailVerificationScreen(
    composeNavigator: ComposeNavigator,
    studentId: String,
    context: Context,
    emailVerificationViewModel: EmailVerificationViewModel = hiltViewModel()
) {
    val isVisible = remember {
        mutableStateOf(false)
    }
    Column {
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
        TextComponent(text = "Enter the verification code sent to the email:", style = TextStyle(color = Color.Black, fontSize = 32.sp), modifier = Modifier.align(Alignment.CenterHorizontally))
        TextComponent(text = emailVerificationViewModel.getStudentEmail(studentId), style = TextStyle(color = Color.Black, fontSize = 32.sp), modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp))
        ButtonComponent(text = "Verify email address", onClick = {
            val task = emailVerificationViewModel.verifyEmailAddress(emailVerificationViewModel.getStudentEmail(studentId))
            if (task?.isSuccessful == true) {
                isVisible.value = true
            } else {
                Toast.makeText(context,"Something went wrong, please try again later", Toast.LENGTH_SHORT).show()
            }
        })
        if (isVisible.value) {
            TextComponent(
                text = "A verification email has been sent to you",
                style = TextStyle(color = Color.Black)
            )
        }
    }
}
