package com.project.authentication.ui.screens.registration

import android.content.Context
import android.widget.Toast
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.project.authentication.ui.components.ButtonComponent
import com.project.authentication.ui.components.PasswordFieldComponent
import com.project.authentication.ui.components.TextComponent
import com.project.authentication.ui.components.TextFieldComponent
import com.project.authentication.ui.screens.registration.viewmodel.RegistrationViewModel
import com.project.authentication.ui.theme.Purple500
import com.project.authentication.ui.theme.Purple700
import com.project.navigator.ComposeNavigator
import com.project.navigator.Screens

@Composable
fun RegistrationScreen(
    navController: ComposeNavigator,
    context: Context
) {
    val registrationViewModel: RegistrationViewModel = hiltViewModel()
    val auth: FirebaseAuth = Firebase.auth
    val emailError = remember {
        mutableStateOf(false)
    }
    val nameError = remember {
        mutableStateOf(false)
    }
    val phoneError = remember {
        mutableStateOf(false)
    }
    val passwordError = remember {
        mutableStateOf(false)
    }
    val confirmPasswordError = remember {
        mutableStateOf(false)
    }
    val usnError = remember {
        mutableStateOf(false)
    }

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
                painter = painterResource(id = com.project.Authentication.R.drawable.vvce_connect_banner),
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
            TextComponent(
                "Sign Up",
                modifier = Modifier,
                style = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Purple700)
            )
            TextFieldComponent("Name", onValueChanged = {
                registrationViewModel.setName(it)
            }, error = nameError.value, errorMessage = "Enter a valid name")
            TextFieldComponent("Phone", onValueChanged = {
                registrationViewModel.setPhoneNumber(it)
            }, error = phoneError.value, errorMessage = "Enter a valid 10 digit phone number")
            TextFieldComponent("USN", onValueChanged = {
                registrationViewModel.setUsn(it)
            }, error = usnError.value, errorMessage = "Enter a valid usn")
            TextFieldComponent("Email id", onValueChanged = {
                registrationViewModel.setEmail(it)
            }, error = emailError.value, errorMessage = "Enter a valid college email id")
            TextFieldComponent("Year of Joining", onValueChanged = {
                registrationViewModel.setYearOfJoining(it)
            })
            TextFieldComponent(label = "Section", onValueChanged = {
                registrationViewModel.setSection(it)
            })
            TextFieldComponent(label = "Batch", onValueChanged = {
                registrationViewModel.setBatch(it)
            })
            PasswordFieldComponent(
                "Password",
                onValueChanged = {
                    registrationViewModel.setPassword(it)
                },
                error = passwordError.value,
                errorMessage = "Enter a password with 8 or more characters",
                imeAction = ImeAction.Next
            )
            PasswordFieldComponent(
                "Confirm Password",
                onValueChanged = {
                    registrationViewModel.setConfirmedPassword(it)
                },
                error = confirmPasswordError.value,
                errorMessage = "Password does not match",
                imeAction = ImeAction.Done,
                onActionDone = {
                    nameError.value = !registrationViewModel.validateName()
                    phoneError.value = !registrationViewModel.validatePhoneNumber()
                    usnError.value = !registrationViewModel.validateUsn()
                    emailError.value = !registrationViewModel.validateEmailId()
                    passwordError.value = !registrationViewModel.validatePassword()
                    confirmPasswordError.value = !registrationViewModel.validateConfirmedPassword()
                    if (!nameError.value && !phoneError.value && !usnError.value && !emailError.value && !passwordError.value && !confirmPasswordError.value) {
                        val task = registrationViewModel.registerStudent()
                        task.addOnCompleteListener {
                            if (task.isSuccessful) {
                                registrationViewModel.insertStudent()
                                val student = hashMapOf(
                                    "uid" to auth.currentUser?.uid.toString(),
                                    "name" to registrationViewModel.name,
                                    "phone" to registrationViewModel.phoneNumber,
                                    "usn" to registrationViewModel.usn,
                                    "email" to registrationViewModel.email,
                                    "password" to registrationViewModel.password,
                                    "year_of_joining" to registrationViewModel.yearOfJoining,
                                    "section" to registrationViewModel.section,
                                    "batch" to registrationViewModel.batch
                                )
                                registrationViewModel.getDepartment()
                                registrationViewModel.addStudentToDb(student)
                                    ?.addOnCompleteListener {
                                        if (it.isSuccessful) {
                                            navController.navigate(Screens.StudentDashboardScreen.route)
                                        } else {
                                            Toast.makeText(
                                                context,
                                                "Something went wrong, please try again.",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }
                                    }
                            } else {
                                Toast.makeText(
                                    context,
                                    "Something went wrong, please try again.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                }
            )

            Spacer(modifier = Modifier.padding(10.dp))
            ButtonComponent("REGISTER") {
                nameError.value = !registrationViewModel.validateName()
                phoneError.value = !registrationViewModel.validatePhoneNumber()
                usnError.value = !registrationViewModel.validateUsn()
                emailError.value = !registrationViewModel.validateEmailId()
                passwordError.value = !registrationViewModel.validatePassword()
                confirmPasswordError.value = !registrationViewModel.validateConfirmedPassword()
                if (!nameError.value && !phoneError.value && !usnError.value && !emailError.value && !passwordError.value && !confirmPasswordError.value) {
                    val task = registrationViewModel.registerStudent()
                    task.addOnCompleteListener {
                        if (task.isSuccessful) {
                            val student = hashMapOf(
                                "uid" to auth.currentUser?.uid.toString(),
                                "name" to registrationViewModel.name,
                                "phone" to registrationViewModel.phoneNumber,
                                "usn" to registrationViewModel.usn,
                                "email" to registrationViewModel.email,
                                "password" to registrationViewModel.password,
                                "year_of_joining" to registrationViewModel.yearOfJoining,
                                "section" to registrationViewModel.section,
                                "batch" to registrationViewModel.batch
                            )
                            registrationViewModel.addStudentToDb(student)?.addOnCompleteListener {
                                if (it.isSuccessful) {
                                    navController.navigate(Screens.StudentDashboardScreen.route)
                                } else {
                                    Toast.makeText(
                                        context,
                                        "Something went wrong, please try again.",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                            navController.navigate(Screens.StudentDashboardScreen.route)
                        } else {
                            Toast.makeText(
                                context,
                                "Something went wrong, please try again.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    "Have an account? Login",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Purple700
                    )
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
