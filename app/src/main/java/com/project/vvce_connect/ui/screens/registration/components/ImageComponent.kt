package com.project.vvce_connect.ui.screens.registration.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.project.vvce_connect.R

@Composable
fun ImageComponent(painter: Painter, content: String) {
    Image(
        painter = painter,
        contentDescription = content,
        contentScale = ContentScale.Crop
    )
}

@Preview(showBackground = true)
@Composable
fun ImageComponentPreview() {
    ImageComponent(painter = painterResource(id = R.drawable.vvce_logo), "VVCE logo")
}
