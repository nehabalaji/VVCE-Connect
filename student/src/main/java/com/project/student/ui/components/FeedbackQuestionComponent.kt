package com.project.student.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FeedbackQuestionComponent(
    modifier: Modifier = Modifier,
    question: String,
    style: TextStyle = TextStyle(fontSize = 16.sp),
    onValueChange: (Float) -> Unit,
) {
    Box(modifier = modifier.padding(10.dp)) {
        Column(modifier = modifier.fillMaxWidth()) {
            TextComponent(text = question, modifier = modifier, style = style)
            SliderComponent(modifier = modifier, onValueChange = onValueChange)
            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                TextComponent(text = "0", modifier = modifier, style = style)
                TextComponent(text = "10", modifier = modifier, style = style)
            }
        }
    }
}