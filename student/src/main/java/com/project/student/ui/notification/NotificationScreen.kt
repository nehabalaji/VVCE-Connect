package com.project.student.ui.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.student.ui.components.TextComponent
import com.project.student.ui.notification.viewmodel.NotificationViewModel
import com.project.student.ui.theme.Purple500
import com.project.student.ui.theme.Purple700

@Composable
fun NotificationScreen(
    notificationViewModel: NotificationViewModel = hiltViewModel()
) {
    val notifications by notificationViewModel.notificationList.collectAsState()
    val notificationList by notifications.collectAsState(initial = emptyList())

    LazyColumn(
        modifier = Modifier.fillMaxSize().background(color = Color.White),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(notificationList) { item ->
            Card(
                modifier = Modifier.padding(8.dp),
                elevation = 10.dp,
                backgroundColor = Purple700,
                shape = MaterialTheme.shapes.large
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    TextComponent(
                        text = item.message,
                        modifier = Modifier,
                        style = TextStyle(fontSize = 16.sp)
                    )
                    TextComponent(
                        text = item.date,
                        modifier = Modifier,
                        style = TextStyle(fontSize = 14.sp)
                    )
                    TextComponent(
                        text = item.teacher,
                        modifier = Modifier,
                        style = TextStyle(fontSize = 12.sp, fontStyle = FontStyle.Italic)
                    )
                }
            }
        }
    }
}
