package com.project.student.ui.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.navigator.ComposeNavigator
import com.project.navigator.Screens
import com.project.student.ui.components.ButtonComponent
import com.project.student.ui.components.TextComponent
import com.project.student.ui.profile.viewmodel.StudentProfileViewModel

@Composable
fun StudentProfileScreen(
    composeNavigator: ComposeNavigator,
    studentProfileViewModel: StudentProfileViewModel = hiltViewModel()
) {
    val student by studentProfileViewModel.student.collectAsState()
    val studentDetails by student.collectAsState(initial = null)

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TextComponent(text = "Name: ", modifier = Modifier, TextStyle(fontSize = 24.sp))
            TextComponent(text = studentDetails?.name.toString(), modifier = Modifier, TextStyle(fontSize = 24.sp))
        }

        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TextComponent(text = "USN: ", modifier = Modifier, TextStyle(fontSize = 24.sp))
            TextComponent(text = studentDetails?.usn.toString().uppercase(), modifier = Modifier, TextStyle(fontSize = 24.sp))
        }

        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TextComponent(text = "Section: ", modifier = Modifier, TextStyle(fontSize = 24.sp))
            TextComponent(text = studentDetails?.section.toString().uppercase(), modifier = Modifier, TextStyle(fontSize = 24.sp))
        }

        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TextComponent(text = "Semester: ", modifier = Modifier, TextStyle(fontSize = 24.sp))
            TextComponent(text = studentDetails?.sem.toString(), modifier = Modifier, TextStyle(fontSize = 24.sp))
        }

        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TextComponent(text = "Department: ", modifier = Modifier, TextStyle(fontSize = 24.sp))
            TextComponent(text = studentDetails?.branch.toString().uppercase(), modifier = Modifier, TextStyle(fontSize = 24.sp))
        }

        Spacer(modifier = Modifier.height(30.dp))

        ButtonComponent(text = "SignOut") {
            studentProfileViewModel.logout()
            composeNavigator.navigateAndClearBackStack(Screens.LoginScreen.route)
        }
    }
}
