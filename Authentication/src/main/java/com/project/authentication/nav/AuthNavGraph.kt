package com.project.authentication.nav

import android.content.Context
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.project.authentication.ui.screens.login.LoginScreen
import com.project.authentication.ui.screens.registration.RegistrationScreen
import com.project.authentication.ui.screens.splash.SplashScreen
import com.project.authentication.ui.screens.verification.EmailVerificationScreen
import com.project.navigator.ComposeNavigator
import com.project.navigator.Routes
import com.project.navigator.Screens

fun NavGraphBuilder.authNavGraph(composeNavigator: ComposeNavigator, context: Context) {
    navigation(
        startDestination = Screens.VvceConnectSplashScreen.name,
        route = Routes.Auth.name,
    ) {
        composable(Screens.VvceConnectSplashScreen.name) {
            SplashScreen(composeNavigator)
        }
        composable(Screens.LoginScreen.name) {
            LoginScreen(context, composeNavigator)
        }
        composable(Screens.RegistrationScreen.name) {
            RegistrationScreen(composeNavigator, context)
        }
        composable(
            Screens.EmailVerificationScreen.name,
        ) {
            EmailVerificationScreen(
                composeNavigator,
                studentId = it.arguments?.getString("user_id").toString(),
                context,
            )
        }
    }
}
