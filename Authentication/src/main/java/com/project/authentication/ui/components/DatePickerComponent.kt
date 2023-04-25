package com.project.authentication.ui.components

import android.app.DatePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import java.util.Calendar

@Composable
fun DatePickerComponent(
    label: String,
    onValueChanged: (String) -> Unit = {},
) {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    var selectedDateText by rememberSaveable() {
        mutableStateOf("")
    }

    var selectedYearText by rememberSaveable() {
        mutableStateOf("")
    }

    val year = calendar[Calendar.YEAR]
    val month = calendar[Calendar.MONTH]
    val dayOfMonth = calendar[Calendar.DAY_OF_MONTH]

    val datePicker: DatePickerDialog = DatePickerDialog(
        context,
        { _, selectedYear, selectedMonth, selectedDayOfMonth ->
            selectedDateText = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
            selectedYearText = "$selectedYear"
        },
        year,
        month,
        dayOfMonth,
    )

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp)
            .clickable {
                datePicker.show()
            },
        enabled = false,
        readOnly = true,
        value = selectedYearText,
        onValueChange = {
            selectedYearText = it
            onValueChanged(it)
        },
        label = { Text(label) },
        trailingIcon = {
            Icon(imageVector = Icons.Filled.ExpandMore, contentDescription = "Drop down Icon")
        },

    )
}
