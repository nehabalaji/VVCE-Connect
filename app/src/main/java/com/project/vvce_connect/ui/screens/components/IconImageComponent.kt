package com.project.vvce_connect.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun IconImageComponent(modifier: Modifier, image: ImageVector, content: String) {
    Image(imageVector = image, contentDescription = content, modifier = modifier)
}

@Preview
@Composable
fun IconImageComponentPreview() {
    IconImageComponent(modifier = Modifier, image = Icons.Filled.BarChart, content = "Bar Chart")
}
