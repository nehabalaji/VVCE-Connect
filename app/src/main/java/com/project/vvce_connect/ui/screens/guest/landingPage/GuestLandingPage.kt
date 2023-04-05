package com.project.vvce_connect.ui.screens.guest.landingPage

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.project.vvce_connect.ui.screens.components.*
import com.project.vvce_connect.ui.screens.localdata.DashboardNavData
import com.project.vvce_connect.ui.screens.localdata.GuestLandingPageData

@Composable
fun GuestLandingPage() {
    ScaffoldComponent(
        modifier = Modifier,
        content = {
            TopAppBarComponent(
                modifier = Modifier,
                title = "Hi Neha",
            )
            GuestLandingPageGrid(
                gridSize = 2,
                items = GuestLandingPageData.getLandingPageData(),
                modifier = Modifier,
            )
        },
        bottomBar = {
            BottomNavigationBar(
                items = DashboardNavData.getBottomNavItems(),
                modifier = Modifier,
            )
        },
    )
}

@Preview
@Composable
fun GuestLandingPagePreview() {
    GuestLandingPage()
}
