package com.project.student.ui.courseWork

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.navigator.ComposeNavigator
import com.project.navigator.Screens
import com.project.student.ui.components.*
import com.project.student.ui.courseWork.viewmodel.CourseWorkViewModel
import com.project.student.ui.theme.Purple500
import com.project.student.ui.theme.Purple700

@Composable
fun CourseWorkScreen(composeNavigator: ComposeNavigator, courseWorkViewModel: CourseWorkViewModel = hiltViewModel()) {
    val subjectList by courseWorkViewModel.subjects.collectAsState()
    val subjectListItems by subjectList.collectAsState(initial = emptyList())

    val loadingSign by courseWorkViewModel.loading.collectAsState()
    val loading by loadingSign.collectAsState(initial = false)

    if (loading) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(color = Purple700)
        }
    } else {
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
                        bottomEnd = 40.dp,
                    ),
                    backgroundColor = Purple500,
                ) {
                    Text(
                        text = "Resources",
                        modifier = Modifier.padding(20.dp),
                        style = TextStyle(
                            fontSize = 36.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        ),
                    )
                }
            }

            items(subjectListItems) {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .clickable {
                            composeNavigator.navigate(Screens.StudentCourseWorkDetails.route.plus("/$it"))
                        },
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = it,
                        modifier = Modifier.padding(16.dp).clickable {
                            composeNavigator.navigate(Screens.StudentCourseWorkDetails.route.plus("/$it"))
                        },
                        style = TextStyle(fontSize = 24.sp),
                    )
                    IconButtonComponent(
                        icon = Icons.Filled.ArrowForwardIos,
                        content = "Right Arrow",
                    )
                }
                Spacer(
                    modifier = Modifier
                        .height(2.dp)
                        .fillMaxWidth()
                        .background(color = Color.Black)
                        .padding(2.dp)
                )
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
