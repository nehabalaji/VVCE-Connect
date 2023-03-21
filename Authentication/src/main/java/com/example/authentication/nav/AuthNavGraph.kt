package com.example.authentication.nav

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.authentication.ui.screens.EmailVerificationScreen
import com.example.authentication.ui.screens.login.LoginScreen
import com.example.authentication.ui.screens.registration.RegistrationScreen
import com.example.authentication.ui.screens.splash.SplashScreen
import com.project.navigator.ComposeNavigator
import com.project.navigator.Routes
import com.project.navigator.Screens

fun NavGraphBuilder.authNavGraph(composeNavigator: ComposeNavigator) {
    navigation(
        startDestination = Screens.VvceConnectSplashScreen.name,
        route = Routes.Auth.name
    ) {
        composable(Screens.VvceConnectSplashScreen.name) {
            SplashScreen(composeNavigator)
        }
        composable(Screens.LoginScreen.name) {
            LoginScreen()
        }
        composable(Screens.RegistrationScreen.name) {
            RegistrationScreen(composeNavigator)
        }
        composable(
            Screens.EmailVerificationScreen.name
        ) {
            EmailVerificationScreen(
                composeNavigator,
                studentId = it.arguments?.getString("user_id").toString()
            )
        }
    }
}
