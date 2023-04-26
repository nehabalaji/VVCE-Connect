package com.project.student.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowLeft
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BoxInBox(modifier: Modifier, text: String, subject: String) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(color = MaterialTheme.colors.secondary),
            contentAlignment = Alignment.Center
        ) {
            TextComponent(
                text = text,
                modifier = Modifier,
                style = TextStyle(
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            )
        }
        Box(
            modifier = modifier
                .fillMaxWidth(0.72f)
                .height(74.dp)
                .width(16.dp)
                .padding(top = 52.dp)
                .background(color = Color.LightGray)
                .align(Alignment.Center)
                .clip(RoundedCornerShape(50)),
            contentAlignment = Alignment.Center
        ) {
            Row(modifier = modifier.clip(RoundedCornerShape(50))) {
                IconButtonComponent(icon = Icons.Filled.ArrowLeft, content = "Left Arrow")
                TextComponent(
                    text = subject,
                    modifier = Modifier,
                    style = TextStyle(
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center
                    )
                )
                IconButtonComponent(icon = Icons.Filled.ArrowRight, content = "Right Arrow")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoxInBoxPreview() {
    BoxInBox(modifier = Modifier, text = "Attendance", subject = "Cryptography")
}