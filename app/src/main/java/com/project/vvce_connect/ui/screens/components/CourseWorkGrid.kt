package com.project.vvce_connect.ui.screens.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.vvce_connect.ui.screens.localdata.CourseWorkData
import com.project.vvce_connect.ui.screens.localdata.CourseWorkDetails

@Composable
fun CourseWorkGrid(
    coursework: List<CourseWorkDetails>,
    modifier: Modifier,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
    ) {
        items(coursework){item->
            CardCourseWork(
                modifier = modifier,
                icon = item.icon,
                title = item.title,
                date = item.date
            )
        }
    }
}

@Preview
@Composable
fun CourseWorkGridPreview() {
    CourseWorkGrid(coursework = CourseWorkData.getCourseWork(), modifier = Modifier)
}
