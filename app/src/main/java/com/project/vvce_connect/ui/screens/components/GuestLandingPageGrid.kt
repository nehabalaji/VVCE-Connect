package com.project.vvce_connect.ui.screens.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.vvce_connect.ui.screens.localdata.GuestLandingPageData
import com.project.vvce_connect.ui.screens.localdata.GuestLandingPageDetails

@Composable
fun GuestLandingPageGrid(
    gridSize: Int,
    items: List<GuestLandingPageDetails>,
    modifier: Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(gridSize),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        content = {
            items(items) { item ->
                GuestCardComponent(modifier = modifier, icon = item.icon, text = item.name)
            }
        },
    )
}

@Preview
@Composable
fun GuestLandingPagePreview() {
    GuestLandingPageGrid(
        gridSize = 2,
        items = GuestLandingPageData.getLandingPageData(),
        modifier = Modifier
    )
}
