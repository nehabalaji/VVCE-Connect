package com.project.vvce_connect.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.project.authentication.nav.authNavGraph
import com.project.navigator.ComposeNavigator
import com.project.navigator.Routes
import com.project.student.nav.studentNavGraph
import com.project.vvce_connect.ui.theme.VVCEConnectTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var composeNavigator: ComposeNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VVCEConnectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    LaunchedEffect(Unit) {
                        composeNavigator.handleNavigationCommands(navController = navController)
                    }
                    NavHost(
                        navController = navController,
                        startDestination = Routes.Auth.name
                    ) {
                        authNavGraph(composeNavigator, this@MainActivity)
                        studentNavGraph(composeNavigator, this@MainActivity)
                    }
                }
            }
        }
    }
}
