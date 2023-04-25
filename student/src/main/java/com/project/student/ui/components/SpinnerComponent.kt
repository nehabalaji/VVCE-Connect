package com.project.student.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SpinnerComponent(
    label: String,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(start = 8.dp, end = 8.dp),
    options: List<Any>,
    onValueChanged: (String) -> Unit = {}
) {
    var expanded by rememberSaveable() {
        mutableStateOf(false)
    }

    var selectedOptionText by rememberSaveable() {
        mutableStateOf("")
    }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp),
            readOnly = true,
            value = selectedOptionText.toString(),
            onValueChange = {
                selectedOptionText = it.toString()
                onValueChanged(it.toString())
            },
            label = { Text(label) },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            },
        ) {
            options.forEach { selectedOption ->
                DropdownMenuItem(
                    onClick = {
                        selectedOptionText = selectedOption.toString()
                        expanded = false
                    },
                ) {
                    Text(text = selectedOption.toString())
                }
            }
        }
    }
}
