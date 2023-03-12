package com.example.authentication.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.authentication.ui.screens.registration.RegistrationScreen
import com.example.authentication.ui.screens.login.LoginScreen
import com.example.authentication.ui.screens.splash.SplashScreen
import com.project.navigator.Routes
import com.project.navigator.Screens

fun NavGraphBuilder.authNavGraph(navController: NavController) {
    navigation(
        startDestination = Screens.VvceConnectSplashScreen.route,
        route = Routes.Auth.name
    ) {
        composable(Screens.VvceConnectSplashScreen.route) {
            SplashScreen(navController)
        }
        composable(Screens.LoginScreen.route) {
            LoginScreen()
        }
        composable(Screens.RegistrationScreen.route) {
            RegistrationScreen(navController)
        }
    }
}
