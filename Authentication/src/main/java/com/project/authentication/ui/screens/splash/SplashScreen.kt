package com.project.authentication.ui.screens.splash

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.google.firebase.auth.FirebaseAuth
import com.project.Authentication.R
import com.project.authentication.ui.components.ImageComponent
import com.project.navigator.ComposeNavigator
import com.project.navigator.Screens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(composeNavigator: ComposeNavigator) {
    val auth: FirebaseAuth = FirebaseAuth.getInstance()
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.6f,
            animationSpec = tween(
                durationMillis = 800,
            ),
        )
        delay(1000)
        val screen = if (auth.currentUser == null) {
            Screens.LoginScreen.route
        } else {
            Screens.StudentDashboardScreen.route
        }
        composeNavigator.navigate(screen) {
            popUpTo(Screens.VvceConnectSplashScreen.route) {
                inclusive = true
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center,
    ) {
        ImageComponent(painter = painterResource(id = R.drawable.vvce_logo), content = "Logo")
    }
}
