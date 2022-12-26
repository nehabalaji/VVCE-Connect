package com.project.vvce_connect.ui.screens.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.project.vvce_connect.R
import com.project.vvce_connect.ui.theme.Purple700
import com.project.vvce_connect.ui.theme.splash_bg
import kotlinx.coroutines.delay

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
        delay(1000)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(splash_bg),
        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(id = R.drawable.vvce_logo), contentDescription = "Logo")
    }
}

@Preview (showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}
