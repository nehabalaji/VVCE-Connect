package com.project.student.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.student.localdata.CheckBoxSubjectData
import com.project.student.localdata.CheckBoxSubjectDetails
import com.project.student.ui.theme.Purple500

@Composable
fun GroupedCheckedBoxComponent(
    itemsList: List<CheckBoxSubjectDetails>,
) {
    itemsList.forEach { items ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            var isChecked by rememberSaveable() {
                mutableStateOf(false)
            }

            Checkbox(
                checked = isChecked,
                onCheckedChange = { isChecked = it },
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Purple500,
                    uncheckedColor = Color.LightGray,
                    checkmarkColor = Color.White,
                ),
            )
            Text(
                text = "${items.subjectId} - ${items.subjectName}",
                modifier = Modifier.padding(start = 8.dp),
                style = TextStyle(
                    fontSize = 16.sp
                )
            )
        }
    }
}

@Preview
@Composable
fun GroupedCheckedBoxComponentPreview() {
    GroupedCheckedBoxComponent(itemsList = CheckBoxSubjectData.getSubjectData())
}
