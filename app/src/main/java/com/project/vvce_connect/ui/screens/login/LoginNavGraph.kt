package com.project.vvce_connect.ui.screens.login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.project.navigator.Routes
import com.project.navigator.Screens

fun NavGraphBuilder.loginNavGraph() {
    navigation(
        startDestination = Screens.LoginScreen.route,
        route = Routes.OnBoarding.name
    ) {
        composable(Screens.LoginScreen.route) {
            LoginScreen()
        }
    }
}
