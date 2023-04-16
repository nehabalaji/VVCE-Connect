package com.project.student.ui.courseWork

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.student.ui.components.CourseWorkGrid
import com.project.student.ui.components.ScaffoldComponent
import com.project.student.ui.courseWork.viewmodel.CourseWorkViewModel
import com.project.student.ui.theme.Purple500

@Composable
fun CourseWorkDetails(
    subjectId: String,
    courseWorkViewModel: CourseWorkViewModel = hiltViewModel(),
) {
    courseWorkViewModel.getResourcesForSubject(subjectId)
    val resource by courseWorkViewModel.resourceList.collectAsState()
    val resourceListItems by resource.collectAsState(initial = emptyList())

    ScaffoldComponent(
        modifier = Modifier,
        topBar = {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                backgroundColor = Purple500,
            ) {
                Text(
                    text = "Resources",
                    modifier = Modifier.padding(20.dp),
                    style = TextStyle(
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                    ),
                )
            }
        },
        content = {
            CourseWorkGrid(coursework = resourceListItems, modifier = Modifier)
        },
    )
}
