package com.project.navigator

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screens(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList(),
) {
    val name: String = route.appendArguments(navArguments)

    // onboarding
    object VvceConnectSplashScreen : Screens("splashScreen")

    // Auth
    object RegistrationScreen : Screens("registrationScreen")
    object LoginScreen : Screens("loginScreen")
    object ForgotPasswordScreen : Screens("forgotPassword")
    object EmailVerificationScreen : Screens(
        "emailVerificationScreen",
        listOf(
            navArgument("user_id") {
                type = NavType.StringType
            },
        ),
    )

    object StudentDashboardScreen : Screens("studentDashboard")

    object StudentAttendance : Screens("studentAttendance")

    object StudentAttendanceDetail : Screens(
        "studentAttendanceDetail",
        listOf(
            navArgument("subject_title") {
                type = NavType.StringType
            },
            navArgument("subject_code") {
                type = NavType.StringType
            },
            navArgument("missed") {
                type = NavType.StringType
            },
            navArgument("attended") {
                type = NavType.StringType
            },
        ),
    )

    object StudentPerformanceReport : Screens("studentPerformanceReport")

    object StudentCourseWork : Screens("studentCourseWork")

    object StudentCourseWorkDetails : Screens(
        "studentCourseWorkDetails",
        listOf(
            navArgument("subject_id") {
                type = NavType.StringType
            },
        ),
    )

    object StudentTimeTable : Screens("studentTimeTable")

    object StudentPlacements : Screens("studentPlacements")

    object StudentExamForm : Screens("studentExamForm")

    object StudentExamFee : Screens("studentExamFee")

    object StudentFeedback : Screens("studentFeedback")

    object StudentFeedbackDetail : Screens(
        "studentFeedbackDetail",
        listOf(
            navArgument("subject_code") {
                type = NavType.StringType
            },
        ),
    )
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
