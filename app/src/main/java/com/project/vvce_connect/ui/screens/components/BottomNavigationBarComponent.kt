package com.project.vvce_connect.ui.screens.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.vvce_connect.ui.screens.student.StudentNavData
import com.project.vvce_connect.ui.screens.student.StudentNavDetails

@Composable
fun BottomNavigationBar(
    items: List<StudentNavDetails>,
    modifier: Modifier,
) {
    BottomNavigation(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.secondary,
        elevation = 5.dp
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                selected = false,
                onClick = {  },
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.name,
                            tint = Color.DarkGray
                        )
                        Text(
                            text = item.name,
                            textAlign = TextAlign.Center,
                            fontSize = 10.sp
                        )
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar(items = StudentNavData.getBottomNavItems(), modifier = Modifier)
}
