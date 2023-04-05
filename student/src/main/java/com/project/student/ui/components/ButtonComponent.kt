package com.project.student.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ButtonComponent(text:String) {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.fillMaxWidth(0.78f),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(vertical = 16.dp),
        )
    }
}

@Preview
@Composable
fun ButtonComponentPreview() {
    ButtonComponent(text = "Sign Up")
}
