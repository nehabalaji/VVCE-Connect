package com.project.student.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.Photo
import androidx.compose.material.icons.filled.PictureAsPdf
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.domain.models.CourseWorkDetails
import com.project.student.ui.theme.Purple500

@Composable
fun CourseWorkGrid(
    coursework: List<CourseWorkDetails>,
    modifier: Modifier,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize().background(color = Purple500),
        contentPadding = PaddingValues(16.dp),
    ) {
        var icon = Icons.Filled.Folder
        items(coursework) { item ->
            when (item.type) {
                "link" -> {
                    icon = Icons.Filled.Link
                }
                "photo" -> {
                    icon = Icons.Filled.Photo
                }
                "pdf" -> {
                    icon = Icons.Filled.PictureAsPdf
                }
            }
            CardCourseWork(
                modifier = modifier,
                icon = icon,
                title = item.name,
                date = item.date,
            )
        }
    }
}
