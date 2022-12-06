package com.project.vvce_connect.ui.screens.registration.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.project.vvce_connect.R

@Composable
fun ImageComponent() {

        Image(
            painter = painterResource(id = R.drawable.vvce_logo),
            contentDescription = "Logo of VVCE",
            contentScale = ContentScale.Crop

        )
}

@Preview(showBackground = true)
@Composable
fun ImageComponentPreview(){
    ImageComponent()
}