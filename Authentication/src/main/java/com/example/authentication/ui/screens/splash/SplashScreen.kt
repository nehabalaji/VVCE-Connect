package com.example.authentication.ui.screens.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.authentication.R
import com.example.authentication.ui.components.ImageComponent
import com.project.vvce_connect.ui.theme.splash_bg

@Composable
fun SplashScreen() {
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.6f,
            animationSpec = tween(
                durationMillis = 800
            )
        )
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(splash_bg),
        contentAlignment = Alignment.Center
    ) {
        ImageComponent(painter = painterResource(id = R.drawable.vvce_logo), content = "Logo")
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}
