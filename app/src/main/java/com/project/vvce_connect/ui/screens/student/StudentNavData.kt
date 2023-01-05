package com.project.vvce_connect.ui.screens.student

import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

object StudentNavData {
    fun getBottomNavItems():List<StudentNavDetails> {
        val bottomNavItemList = listOf<StudentNavDetails>(
            StudentNavDetails(
                name = "Home",
                icon = Icons.Filled.Home
            ),
            StudentNavDetails(
                name = "Notification",
                icon = Icons.Filled.Notifications
            ),
            StudentNavDetails(
                name = "Setting",
                icon = Icons.Filled.Settings
            ),
            StudentNavDetails(
                name = "Profile",
                icon = Icons.Filled.Person
            )
        )
        return bottomNavItemList
    }
}
