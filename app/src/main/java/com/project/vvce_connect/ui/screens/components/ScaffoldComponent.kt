package com.project.vvce_connect.ui.screens.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.project.vvce_connect.ui.screens.localdata.DashboardNavData

@Composable
fun ScaffoldComponent(
    modifier: Modifier,
    topBar: @Composable () -> Unit = {},
    content: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {}
) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
    var pad: PaddingValues ? = null
    Scaffold(
        scaffoldState = scaffoldState,
        backgroundColor = MaterialTheme.colors.secondary,
        content = { padding ->
            Column() {
                topBar()
                content()
            }
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
        content = {
            TopAppBarComponent(
                modifier = Modifier,
                title = "Hi Neha"
            )
            FeaturesGridComponent(
                gridSize = 2,
                items = DashboardNavData.getStudentDashboardItems(),
                modifier = Modifier
            )
        },
        bottomBar = {
            BottomNavigationBar(
                items = DashboardNavData.getBottomNavItems(),
                modifier = Modifier
            )
        }
    )
}
