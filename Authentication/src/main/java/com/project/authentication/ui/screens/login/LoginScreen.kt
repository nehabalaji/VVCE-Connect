package com.project.authentication.ui.screens.login

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.Authentication.R
import com.project.authentication.ui.components.*
import com.project.authentication.ui.screens.login.viewmodel.LoginViewModel
import com.project.authentication.ui.theme.Purple500
import com.project.authentication.ui.theme.Purple700
import com.project.domain.models.Student
import com.project.navigator.ComposeNavigator
import com.project.navigator.Screens
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    context: Context,
    composeNavigator: ComposeNavigator,
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    val emailError = remember {
        mutableStateOf(false)
    }
    val passwordError = remember {
        mutableStateOf(false)
    }
    val loading = remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
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
        if (loading.value) {
            LinearProgressIndicator(color = Purple700)
        }
        Spacer(modifier = Modifier.padding(16.dp))
        TextComponent(text = "Login", modifier = Modifier, style = TextStyle(fontSize = MaterialTheme.typography.h3.fontSize, fontWeight = FontWeight.Bold))
        Spacer(modifier = Modifier.padding(12.dp))
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
                loading.value = true
                loginViewModel.loginUser().addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        coroutineScope.launch(Dispatchers.IO) {
                            if (loginViewModel.getStudent() == null) {
                                loginViewModel.getStudentFromFireStore(loginViewModel.email)
                                    .addOnCompleteListener {
                                        if (it.isSuccessful) {
                                            val usn = it.result.data?.get("usn").toString()
                                            val name = it.result.data?.get("name").toString()
                                            val phone = it.result.data?.get("phone").toString()
                                            val yearOfJoining =
                                                it.result.data?.get("year_of_joining").toString()
                                            val sem = it.result.data?.get("sem").toString()
                                            val branch = it.result.data?.get("branch").toString()
                                            val section = it.result.data?.get("section").toString()
                                            val student = Student(
                                                name,
                                                phone,
                                                usn,
                                                loginViewModel.email,
                                                yearOfJoining,
                                                sem,
                                                branch,
                                                section
                                            )
                                            Log.v("STUDENT", student.toString())
                                            loginViewModel.insertStudent(student)
                                            composeNavigator.navigate(Screens.StudentDashboardScreen.route)
                                        }
                                    }
                            } else {
                                composeNavigator.navigate(Screens.StudentDashboardScreen.route)
                            }
                        }
                    } else {
                        loading.value = false
                        Toast.makeText(context, "Please check your credentials", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        )
        Spacer(modifier = Modifier.padding(16.dp))
        ButtonComponent(text = "Login", onClick = {
            emailError.value = !loginViewModel.validateEmailId()
            passwordError.value = !loginViewModel.validatePassword()
            loading.value = true
            loginViewModel.loginUser().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    coroutineScope.launch(Dispatchers.IO) {
                        if (loginViewModel.getStudent() == null) {
                            loginViewModel.getStudentFromFireStore(loginViewModel.email)
                                .addOnCompleteListener {
                                    if (it.isSuccessful) {
                                        val usn = it.result.data?.get("usn").toString()
                                        val name = it.result.data?.get("name").toString()
                                        val phone = it.result.data?.get("phone").toString()
                                        val yearOfJoining =
                                            it.result.data?.get("year_of_joining").toString()
                                        val sem = it.result.data?.get("sem").toString()
                                        val branch = it.result.data?.get("branch").toString()
                                        val section = it.result.data?.get("section").toString()
                                        val student = Student(
                                            name,
                                            phone,
                                            usn,
                                            loginViewModel.email,
                                            yearOfJoining,
                                            sem,
                                            branch,
                                            section
                                        )
                                        Log.v("STUDENT", student.toString())
                                        loginViewModel.insertStudent(student)
                                        composeNavigator.navigate(Screens.StudentDashboardScreen.route)
                                    }
                                }
                        } else {
                            composeNavigator.navigate(Screens.StudentDashboardScreen.route)
                        }
                    }
                } else {
                    loading.value = false
                    Toast.makeText(context, "Please check your credentials", Toast.LENGTH_SHORT).show()
                }
            }
        })
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.clickable {
                composeNavigator.navigate(Screens.RegistrationScreen.route)
            }.padding(16.dp)
        ) {
            Text(
                "Don't have an account? Register here",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Purple700
                )
            )
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Next Button",
                modifier = Modifier.size(16.dp)
            )
        }
    }
}
