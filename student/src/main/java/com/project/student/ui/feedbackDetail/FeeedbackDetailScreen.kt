package com.project.student.ui.feedbackDetail

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.domain.models.FeedbackQuestion
import com.project.navigator.ComposeNavigator
import com.project.student.ui.components.ButtonComponent
import com.project.student.ui.components.FeedbackQuestionComponent
import kotlin.math.roundToInt

@Composable
fun FeedbackDetailScreen(
    composeNavigator: ComposeNavigator,
    subjectCode: String,
    modifier: Modifier = Modifier,
    viewModel: FeedbackDetailViewModel = hiltViewModel(),
) {
    val questionsList by viewModel.questionsList.collectAsState()
    val questionsListItems by questionsList.collectAsState(initial = emptyList())

    LaunchedEffect(key1 = true) {
        viewModel.getQuestions(subjectCode)
    }
    LazyColumn {
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
            ) {
                Text(text = subjectCode)
            }
        }

        items(questionsListItems) {
            FeedbackQuestionComponent(
                question = it.question,
                onValueChange = { value ->
                    viewModel.onValueChanged(
                        FeedbackQuestion(
                            it.question,
                            value.roundToInt().toString(),
                        ),
                    )
                },
            )
        }
        item {
            ButtonComponent(text = "Submit", onClick = {
                viewModel.onSubmitClicked(subjectCode)
            })
        }
    }
}
