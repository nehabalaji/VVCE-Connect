package com.project.navigator

import androidx.navigation.NamedNavArgument

sealed class Screens(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList()
) {
    var name: String = route.appendArguments(navArguments)

    // onboarding
    object VvceConnectSplashScreen : Screens("splashScreen")

    // Auth
    object RegistrationScreen : Screens("registrationScreen")
    object LoginScreen : Screens("loginScreen")
    object ForgotPasswordScreen : Screens("forgotPassword")
}

sealed class Routes(val name: String) {
    object OnBoarding : Routes("onboardingRoute")
    object Auth : Routes("authenticationRoute")
}

private fun String.appendArguments(navArguments: List<NamedNavArgument>): String {
    val mandatoryArguments = navArguments.filter { it.argument.defaultValue == null }
        .takeIf { it.isNotEmpty() }
        ?.joinToString(separator = "/", prefix = "/") { "{${it.name}}" }
        .orEmpty()
    val optionalArguments = navArguments.filter { it.argument.defaultValue != null }
        .takeIf { it.isNotEmpty() }
        ?.joinToString(separator = "&", prefix = "?") { "${it.name}={${it.name}}" }
        .orEmpty()
    return "$this$mandatoryArguments$optionalArguments"
}
