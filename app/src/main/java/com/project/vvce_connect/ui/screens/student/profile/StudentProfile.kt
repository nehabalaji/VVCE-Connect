package com.project.vvce_connect.ui.screens.student.profile



import android.net.Uri
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.project.vvce_connect.R
import androidx.activity.compose.rememberLauncherForActivityResult as rememberLauncherForActivityResult
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.project.vvce_connect.ui.screens.components.ButtonComponent

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

        ContactImage()

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

@Composable
fun ContactImage() {
    val imageUri = rememberSaveable { mutableStateOf("") }
    val painter = rememberImagePainter(
        if (imageUri.value.isEmpty())
            R.drawable.user
        else
            imageUri.value

    )

    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let { imageUri.value = it.toString() }
    }


    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(shape = CircleShape, modifier = Modifier
            .padding(8.dp)
            .size(100.dp)) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .clickable { launcher.launch("image/*") },
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview
@Composable
fun StudentProfilePreview() {
    StudentProfile()
}