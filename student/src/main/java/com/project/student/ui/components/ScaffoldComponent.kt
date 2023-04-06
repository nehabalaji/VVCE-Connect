package com.project.student.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.project.student.localdata.DashboardNavData

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
        backgroundColor = Color.White,
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
