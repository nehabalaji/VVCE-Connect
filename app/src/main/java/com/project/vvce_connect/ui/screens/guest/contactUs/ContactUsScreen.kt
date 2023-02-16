package com.project.vvce_connect.ui.screens.guest.contactUs

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.vvce_connect.ui.screens.components.ButtonComponent
import com.project.vvce_connect.ui.screens.components.TextComponent

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ContactUsScreen() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(8.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color(0x00E5FF))
        ) {
            TextComponent(
                text = "Contact Us",
                modifier = Modifier.width(100.dp),
                style = TextStyle(color = Color.Black)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            TextComponent(
                text = "Courses",
                modifier = Modifier,
                style = TextStyle(color = Color.Black)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            val contextForToast = LocalContext.current.applicationContext

            val listItems = arrayOf("BE/B.Tech", "M.Tech", "MBA")

            var selectedItem by remember {
                mutableStateOf(listItems[0])
            }

            var expanded by remember {
                mutableStateOf(false)
            }

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = {
                    expanded = !expanded
                }
            ) {

                TextField(
                    value = selectedItem,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text(text = "Courses") },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(
                            expanded = expanded
                        )
                    },
                    colors = ExposedDropdownMenuDefaults.textFieldColors()
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    listItems.forEach { selectedOption ->

                        DropdownMenuItem(onClick = {
                            selectedItem = selectedOption
                            Toast.makeText(contextForToast, selectedOption, Toast.LENGTH_SHORT)
                                .show()
                            expanded = false
                        }) {
                            Text(text = selectedOption)
                        }
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            val textValue = remember {
                mutableStateOf("")
            }
            OutlinedTextField(
                value = textValue.value,
                onValueChange = { textValue.value = it },
                label = { Text(text = "Name") }
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            val textValue = remember {
                mutableStateOf("")
            }
            OutlinedTextField(
                value = textValue.value,
                onValueChange = { textValue.value = it },
                label = { Text(text = "Phone number") }
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            val textValue = remember {
                mutableStateOf("")
            }
            OutlinedTextField(
                value = textValue.value,
                onValueChange = { textValue.value = it },
                label = { Text(text = "Email") }
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            TextComponent(
                text = "Interested Branch",
                modifier = Modifier,
                style = TextStyle(color = Color.Black)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            val contextForToast = LocalContext.current.applicationContext

            val listItems = arrayOf(
                "Computer Science and Engineering",
                "Information Science and Engineering",
                "Electronics and Communication Engineering",
                "Electrical and Electronics Engineering",
                "Mechanical Engineering",
                "Civil Engineering"
            )

            var selectedItem by remember {
                mutableStateOf(listItems[0])
            }

            var expanded by remember {
                mutableStateOf(false)
            }

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = {
                    expanded = !expanded
                }
            ) {

                TextField(
                    value = selectedItem,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text(text = "Courses") },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(
                            expanded = expanded
                        )
                    },
                    colors = ExposedDropdownMenuDefaults.textFieldColors()
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    listItems.forEach { selectedOption ->

                        DropdownMenuItem(onClick = {
                            selectedItem = selectedOption
                            Toast.makeText(contextForToast, selectedOption, Toast.LENGTH_SHORT)
                                .show()
                            expanded = false
                        }) {
                            Text(text = selectedOption)
                        }
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            TextComponent(
                text = "Entrance Examination Taken",
                modifier = Modifier,
                style = TextStyle(color = Color.Black)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            val examList: List<String> = listOf("K-CET", "Comedk", "JEE", "Other")

            val contextForToast = LocalContext.current.applicationContext

            Column(horizontalAlignment = Alignment.Start) {

                examList.forEach { examName ->

                    var checked by remember {
                        mutableStateOf(true)
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = checked,
                            onCheckedChange = { checked_ ->
                                checked = checked_
                                Toast.makeText(
                                    contextForToast,
                                    "$examName $checked_",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                        )

                        Text(
                            modifier = Modifier.padding(start = 2.dp),
                            text = examName
                        )
                    }
                }
            }
        }

        ButtonComponent(text = "Submit")

    }
}

@Preview
@Composable
fun ContactUsScreenPreview() {
    ContactUsScreen()
}


