package com.project.vvce_connect.ui.screens.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.project.vvce_connect.ui.screens.student.StudentNavData

@Composable
fun ScaffoldComponent(
    modifier: Modifier,
    topBar: @Composable () -> Unit = {},
    content: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {}
) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
    var pad:PaddingValues ?= null
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            topBar()
        },
        backgroundColor = MaterialTheme.colors.secondary,
        content = { padding ->
                  content()
            pad = padding
        },
        bottomBar = {
            bottomBar()
        }
    )
}

@Preview
@Composable
fun ScaffoldComponentPreview() {
    ScaffoldComponent(
        modifier = Modifier,
        topBar = {
            TopAppBarComponent(
                modifier = Modifier,
                title = "Hi Neha"
            )
        },
        content = {
            FeaturesGridComponent(
                gridSize = 2,
                items = StudentNavData.getFeatureGridItems(),
                modifier = Modifier
            )
        },
        bottomBar = {
            BottomNavigationBar(
                items = StudentNavData.getBottomNavItems(),
                modifier = Modifier
            )
        }
    )
}
