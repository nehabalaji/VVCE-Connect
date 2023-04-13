package com.project.student.ui.courseWork

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.student.ui.components.CourseWorkGrid
import com.project.student.ui.courseWork.viewmodel.CourseWorkViewModel

@Composable
fun CourseWorkDetails(
    subjectId: String,
    courseWorkViewModel: CourseWorkViewModel = hiltViewModel()
) {
    courseWorkViewModel.getResourcesForSubject(subjectId)
    val resource by courseWorkViewModel.resourceList.collectAsState()
    val resourceListItems by resource.collectAsState(initial = emptyList())

    CourseWorkGrid(coursework = resourceListItems, modifier = Modifier)
}
