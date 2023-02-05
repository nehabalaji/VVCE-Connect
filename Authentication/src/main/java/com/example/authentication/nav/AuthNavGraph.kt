package com.example.authentication.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.authentication.ui.registration.RegistrationScreen
import com.example.authentication.ui.screens.login.LoginScreen
import com.example.authentication.ui.screens.splash.SplashScreen
import com.project.navigator.Routes
import com.project.navigator.Screens

fun NavGraphBuilder.authNavGraph() {
    navigation(
        startDestination = Screens.VvceConnectSplashScreen.route,
        route = Routes.Auth.name
    ) {
        composable(Screens.VvceConnectSplashScreen.route) {
            SplashScreen()
        }
        composable(Screens.LoginScreen.route) {
            LoginScreen()
        }
        composable(Screens.RegistrationScreen.route) {
            RegistrationScreen()
        }
    }
}
