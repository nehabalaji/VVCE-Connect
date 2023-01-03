package com.project.vvce_connect.ui.screens.splash

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.project.navigator.Routes
import com.project.navigator.Screens

fun NavGraphBuilder.splashNavGraph() {
    navigation(
        startDestination = Screens.VvceConnectSplashScreen.route,
        route = Routes.OnBoarding.name
    ) {
        composable(Screens.VvceConnectSplashScreen.route) {
            SplashScreen()
        }
    }
}
