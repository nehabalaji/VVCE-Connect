package com.project.vvce_connect.ui.screens.components

import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SliderComponent(modifier: Modifier) {
    var position by rememberSaveable() {
        mutableStateOf(0f)
    }
    Slider(
        modifier = modifier,
        value = position,
        onValueChange = { position = it },
        valueRange = 0f..5f,
        steps = 5,
        colors = SliderDefaults.colors(),
    )
}

@Preview(showBackground = true)
@Composable
fun SliderComponentPreview() {
    SliderComponent(modifier = Modifier)
}
