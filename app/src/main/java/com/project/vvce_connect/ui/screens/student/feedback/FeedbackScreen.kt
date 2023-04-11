package com.project.vvce_connect.ui.screens.student.feedback

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.vvce_connect.ui.screens.components.BoxInBox
import com.project.vvce_connect.ui.screens.components.FeedbackQuestionComponent
import com.project.vvce_connect.ui.screens.components.TextComponent

@Composable
fun FeedbackScreen(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        BoxInBox(modifier = modifier, text = "Feedback", subject = "Computer Network")
        FeedbackQuestionComponent(modifier = modifier.padding(start = 10.dp, end = 12.dp), question = "1.Punctuality of the faculty", style = TextStyle(fontSize = 16.sp))
        FeedbackQuestionComponent(modifier = modifier.padding(start = 10.dp, end = 12.dp), question = "2.Delivery of the course content", style = TextStyle(fontSize = 16.sp))
        FeedbackQuestionComponent(modifier = modifier.padding(start = 10.dp, end = 12.dp), question = "3.Ability to explain difficult concepts and clarify the doubts", style = TextStyle(fontSize = 16.sp))
        FeedbackQuestionComponent(modifier = modifier.padding(start = 10.dp, end = 12.dp), question = "4.Ability to motivate and promote faculty student interactions", style = TextStyle(fontSize = 16.sp))
        FeedbackQuestionComponent(modifier = modifier.padding(start = 10.dp, end = 12.dp), question = "5.Voice clarity and modulation", style = TextStyle(fontSize = 16.sp))
        FeedbackQuestionComponent(modifier = modifier.padding(start = 10.dp, end = 12.dp), question = "6.Effective usage of blackboard and modern teaching aids", style = TextStyle(fontSize = 16.sp))
        FeedbackQuestionComponent(modifier = modifier.padding(start = 10.dp, end = 12.dp), question = "7.Overall classroom management", style = TextStyle(fontSize = 16.sp))
        FeedbackQuestionComponent(modifier = modifier.padding(start = 10.dp, end = 12.dp), question = "8.Syllabus coverage as per the Calendar of Events/lesson plan", style = TextStyle(fontSize = 16.sp))
        FeedbackQuestionComponent(modifier = modifier.padding(start = 10.dp, end = 12.dp), question = "9.Transparency and fairness in assessing and providing timely feedback", style = TextStyle(fontSize = 16.sp))
        FeedbackQuestionComponent(modifier = modifier.padding(start = 10.dp, end = 12.dp), question = "10.Comprehensive coverage of course to meet course objectives and course outcomes", style = TextStyle(fontSize = 16.sp))
        TextComponent(text = "NOTE: 0 being the lowest and 5 being the highest", modifier = modifier, style = TextStyle(fontSize = 24.sp))
    }
}

@Preview(showBackground = true)
@Composable
fun FeedbackScreenPreview() {
    FeedbackScreen(modifier = Modifier)
}
