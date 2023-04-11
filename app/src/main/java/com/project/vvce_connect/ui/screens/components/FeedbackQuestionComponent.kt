package com.project.vvce_connect.ui.screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FeedbackQuestionComponent(modifier: Modifier, question: String, style: TextStyle) {
    Box(modifier = modifier.padding(10.dp)) {
        Column(modifier = modifier.fillMaxWidth()) {
            TextComponent(text = question, modifier = modifier, style = style)
            SliderComponent(modifier = modifier)
            Row(
                modifier = modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                TextComponent(text = "0", modifier = modifier, style = style)
                Spacer(modifier = modifier.padding(start = 230.dp))
                TextComponent(text = "5", modifier = modifier, style = style)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FeedbackQuestionComponentPreview() {
    FeedbackQuestionComponent(modifier = Modifier, question = "Rate the teacher", style = TextStyle(fontSize = 16.sp))
}
