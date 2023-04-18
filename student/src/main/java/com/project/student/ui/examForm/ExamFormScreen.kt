package com.project.student.ui.examForm

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.student.localdata.CheckBoxSubjectData
import com.project.student.ui.components.ButtonComponent
import com.project.student.ui.components.GroupedCheckedBoxComponent
import com.project.student.ui.components.SpinnerComponent
import com.project.student.ui.components.TextComponent
import com.project.student.ui.components.TextFieldComponent
import com.project.student.ui.theme.Purple500
import com.project.student.ui.theme.Purple700

@Composable
fun ExamFormScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 0.dp,
                bottomStart = 40.dp,
                bottomEnd = 40.dp,
            ),
            backgroundColor = Purple500,
        ) {
            Text(
                text = "Exam Form",
                modifier = Modifier.padding(20.dp),
                style = TextStyle(
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                ),
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TextComponent(
                text = "VTU Exams 2023",
                modifier = Modifier,
                style = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Purple700),
            )
            TextFieldComponent(label = "Name")
            TextFieldComponent(label = "USN")
            TextFieldComponent(label = "Email id")
            SpinnerComponent(label = "Branch", options = listOf("AI & ML", "CSE", "ISE", "Mechanical", "ECE", "EEE", "Civil"))
            SpinnerComponent(label = "Semester", options = listOf(1, 2, 3, 4, 5, 6, 7, 8))
            SpinnerComponent(label = "Section", options = listOf("A", "B", "C"))
            SpinnerComponent(label = "Year of Joining", options = listOf("2019", "2020", "2021", "2022", "2023", "2024"))
            TextComponent(
                text = "Subject List",
                modifier = Modifier,
                style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Purple700)
            )
            GroupedCheckedBoxComponent(itemsList = CheckBoxSubjectData.getSubjectData())
            ButtonComponent(text = "Submit Form")
        }
    }
}

@Preview
@Composable
fun ExamFormScreenPreview() {
    ExamFormScreen()
}
