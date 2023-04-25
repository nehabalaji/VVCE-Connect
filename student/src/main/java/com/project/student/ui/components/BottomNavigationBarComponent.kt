package com.project.student.ui.components

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.project.navigator.ComposeNavigator
import com.project.student.localdata.DashboardNavDetails
import com.project.student.ui.dashboard.viewmodel.StudentDashboardViewModel

@Composable
fun BottomNavigationBar(
    items: List<DashboardNavDetails>,
    modifier: Modifier,
    composeNavigator: ComposeNavigator,
    studentDashboardViewModel: StudentDashboardViewModel,
    context: Context
) {
    val screen = remember { mutableStateOf("Home") }
    val isSelectedHome = remember { mutableStateOf(true) }
    val isSelectedNotifications = remember { mutableStateOf(false) }
    val isSelectedProfile = remember { mutableStateOf(false) }
    BottomNavigation(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.secondary,
        elevation = 5.dp
    ) {
        items.forEach { item ->
            screen.value = item.screen
            val isSelected = when (item.screen) {
                "Home" -> isSelectedHome.value
                "Notification" -> isSelectedNotifications.value
                "Profile" -> isSelectedProfile.value
                else -> false
            }
            BottomNavigationItem(
                selected = isSelected,
                onClick = {
                    when (item.screen) {
                        "Home" -> {
                            isSelectedHome.value = true
                            isSelectedNotifications.value = false
                            isSelectedProfile.value = false
                        }
                        "Notification" -> {
                            isSelectedHome.value = false
                            isSelectedNotifications.value = true
                            isSelectedProfile.value = false
                        }
                        "Profile" -> {
                            isSelectedHome.value = false
                            isSelectedNotifications.value = false
                            isSelectedProfile.value = true
                        }
                    }
                    if (item.screen == "About Us") {
                        val packageName = "com.android.chrome"
                        val url = "https://vvce.ac.in/about-us/"
                        val builder = CustomTabsIntent.Builder()
                        builder.setShowTitle(true)
                        builder.setInstantAppsEnabled(true)
                        builder.setToolbarColor(ContextCompat.getColor(context, com.project.student.R.color.purple_500))
                        val customBuilder = builder.build()
                        customBuilder.intent.setPackage(packageName)
                        customBuilder.launchUrl(context, Uri.parse(url))
                    } else {
                        studentDashboardViewModel.setScreen(item.screen)
                    }
                },
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.name,
                            tint = if (isSelected) Color.White else Color.Black
                        )
                        Text(
                            text = item.name,
                            textAlign = TextAlign.Center,
                            fontSize = 10.sp,
                            color = if (isSelected) Color.White else Color.Black
                        )
                    }
                }
            )
        }
    }
}
