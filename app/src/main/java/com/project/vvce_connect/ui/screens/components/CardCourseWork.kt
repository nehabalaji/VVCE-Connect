package com.project.vvce_connect.ui.screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VideoFile
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardCourseWork(modifier: Modifier, icon: ImageVector, title: String, date: String) {
    Card(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(120.dp)
            .verticalScroll(rememberScrollState()),
        elevation = 10.dp,
        backgroundColor = MaterialTheme.colors.background,
    ) {
        Row(modifier = modifier.padding(end = 24.dp), verticalAlignment = Alignment.CenterVertically) {
            IconImageComponent(modifier = modifier.size(50.dp), image = icon, content = "Icon")
            Column(modifier = modifier) {
                TextComponent(text = title, modifier = modifier, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp))
                TextComponent(text = date, modifier = modifier, style = TextStyle(fontSize = 12.sp))
            }
        }
    }
}

@Preview
@Composable
fun CardCourseWorkPreview() {
    CardCourseWork(modifier = Modifier, icon = Icons.Filled.VideoFile, title = "Intro To IOT", date = "12/08/2022")
}
