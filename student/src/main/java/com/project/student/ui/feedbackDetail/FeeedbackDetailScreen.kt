package com.project.student.ui.feedbackDetail

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.domain.models.FeedbackQuestion
import com.project.navigator.ComposeNavigator
import com.project.navigator.Screens
import com.project.student.ui.components.ButtonComponent
import com.project.student.ui.components.FeedbackQuestionComponent
import com.project.student.ui.theme.Purple500
import kotlin.math.roundToInt

@Composable
fun FeedbackDetailScreen(
    composeNavigator: ComposeNavigator,
    subjectCode: String,
    modifier: Modifier = Modifier,
    context: Context,
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
                backgroundColor = Purple500
            ) {
                Text(
                    text = subjectCode,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(20.dp),
                    style = TextStyle(
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                    )
                )
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
                Toast.makeText(context, "Feedback successfully submitted!", Toast.LENGTH_SHORT).show()
                composeNavigator.navigateAndClearBackStack(Screens.StudentDashboardScreen.route)
            })
        }
    }
}
