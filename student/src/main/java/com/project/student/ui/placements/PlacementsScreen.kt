package com.project.student.ui.placements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.student.ui.components.TextComponent
import com.project.student.ui.theme.Purple500
import com.project.student.ui.theme.Purple700

@Composable
fun PlacementsScreen() {
    Card(
        modifier = Modifier.padding(8.dp),
        elevation = 10.dp,
        backgroundColor = Purple500,
        shape = MaterialTheme.shapes.large
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            TextComponent(
                text = "Sample Company",
                modifier = Modifier,
                style = TextStyle(fontSize = 24.sp)
            )
            TextComponent(
                text = "ioehurwjd oweihurbjeweoqp[w owhfiuge4bwocd woiuyfhvebajksk wq3wgyuibhjnlk iquywud iuwg iowiugqw ihwuigqd wihqugefbjhkasc ;wlkjbhes",
                modifier = Modifier,
                style = TextStyle(fontSize = 16.sp)
            )
            TextComponent(
                text = "Eligible branches: CS, IS",
                modifier = Modifier,
                style = TextStyle(fontSize = 16.sp)
            )
            TextComponent(
                text = "Eligible semesters: 7, 8",
                modifier = Modifier,
                style = TextStyle(fontSize = 16.sp)
            )
            TextComponent(
                text = "For more details, contact TAP department",
                modifier = Modifier,
                style = TextStyle(fontSize = 16.sp, fontStyle = FontStyle.Italic)
            )
        }
    }
}
