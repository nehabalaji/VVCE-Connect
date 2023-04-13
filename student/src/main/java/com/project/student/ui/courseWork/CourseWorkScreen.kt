package com.project.student.ui.courseWork

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.navigator.ComposeNavigator
import com.project.navigator.Screens
import com.project.student.ui.components.*
import com.project.student.ui.courseWork.viewmodel.CourseWorkViewModel

@Composable
fun CourseWorkScreen(composeNavigator: ComposeNavigator, courseWorkViewModel: CourseWorkViewModel = hiltViewModel()) {
    val subjectList by courseWorkViewModel.subjects.collectAsState()
    val subjectListItems by subjectList.collectAsState(initial = emptyList())

    LazyColumn() {
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomStart = 40.dp,
                    bottomEnd = 40.dp
                )
            ) {
                Text(text = "Resources")
            }
        }

        items(subjectListItems) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        composeNavigator.navigate(Screens.StudentCourseWorkDetails.route.plus("/$it"))
                    },
                shape = RoundedCornerShape(
                    10.dp
                )
            ) {
                Text(text = it)
            }
        }
    }
//    ScaffoldComponent(
//        modifier = modifier,
//        content = {
//            BoxInBox(
//                modifier = modifier,
//                text = title,
//                subject = subject
//            )
//            TextComponent(text = courseWorkViewModel.subjectList.toString(), modifier = Modifier, style = TextStyle(fontSize = 20.sp))
// //            Log.v("TAG", courseWorkViewModel.subjects.toString())
// //            CourseWorkGrid(coursework = , modifier = modifier)
//        },
//        bottomBar = {
//            BottomNavigationBar(
//                items = DashboardNavData.getBottomNavItems(),
//                modifier = modifier
//            )
//        }
//    )
}

// @Preview
// @Composable
// fun CourseWorkScreenPreview() {
//    CourseWorkScreen(modifier = Modifier, title = "Course Work", subject = "Computer Network")
// }
