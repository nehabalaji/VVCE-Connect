package com.project.vvce_connect.ui.screens.student.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.project.vvce_connect.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.project.vvce_connect.ui.screens.components.ButtonComponent
import com.project.vvce_connect.ui.screens.components.ImageComponent

@Composable
fun StudentProfile(){
    var name by rememberSaveable{ mutableStateOf("default name") }
    var usn by rememberSaveable{ mutableStateOf("default usn") }
    var section by rememberSaveable{ mutableStateOf("default section") }
    var semester by rememberSaveable{ mutableStateOf("default semester") }
    var department by rememberSaveable{ mutableStateOf("default department") }
    var mentor by rememberSaveable{ mutableStateOf("default mentor") }
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .padding(8.dp)) {

        ImageComponent(painter = painterResource(id = R.drawable.user) , content = "Contact Image")

        Row(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Name", modifier = Modifier.width(100.dp))
            TextField(value = name, onValueChange = {name = it}, colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                textColor = Color.Black
            ))
        }

        Row(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),verticalAlignment = Alignment.CenterVertically) {
            Text(text = "USN", modifier = Modifier.width(100.dp))
            TextField(value = usn, onValueChange = {usn = it}, colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                textColor = Color.Black
            ))
        }

        Row(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Section", modifier = Modifier.width(100.dp))
            TextField(value = section, onValueChange = {section = it}, colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                textColor = Color.Black
            ))
        }

        Row(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Semester", modifier = Modifier.width(100.dp))
            TextField(value = semester , onValueChange = { semester = it}, colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                textColor = Color.Black
            ))
        }

        Row(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Department", modifier = Modifier.width(100.dp))
            TextField(value = department , onValueChange = { department = it}, colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                textColor = Color.Black
            ))
        }

        Row(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Mentor", modifier = Modifier.width(100.dp))
            TextField(value = mentor , onValueChange = { mentor = it}, colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                textColor = Color.Black
            ))
        }

        ButtonComponent(text = "SignOut")

    }
}

@Preview
@Composable
fun StudentProfilePreview() {
    StudentProfile()
}