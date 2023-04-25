package com.project.student.ui.components

import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SliderComponent(modifier: Modifier, onValueChange: (Float) -> Unit) {
    var position by rememberSaveable {
        mutableStateOf(0f)
    }
    Slider(
        modifier = modifier,
        value = position,
        onValueChange = {
            position = it
            onValueChange(it)
        },
        valueRange = 0f..10f,
        steps = 10,
        colors = SliderDefaults.colors(),
    )
}
