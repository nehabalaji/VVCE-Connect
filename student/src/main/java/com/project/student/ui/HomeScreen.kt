package com.project.student.ui

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.project.navigator.ComposeNavigator
import com.project.student.localdata.DashboardNavData
import com.project.student.ui.components.FeaturesGridComponent

@Composable
fun HomeScreen(
    composeNavigator: ComposeNavigator
) {
    FeaturesGridComponent(
        gridSize = 2,
        items = DashboardNavData.getStudentDashboardItems(),
        modifier = Modifier.background(Color.White),
        composeNavigator = composeNavigator
    )
}