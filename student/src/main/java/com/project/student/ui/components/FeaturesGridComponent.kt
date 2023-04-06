package com.project.student.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.project.navigator.ComposeNavigator
import com.project.student.localdata.DashboardNavDetails
import com.project.student.ui.theme.Purple700

@Composable
fun FeaturesGridComponent(
    gridSize: Int,
    items: List<DashboardNavDetails>,
    modifier: Modifier,
    composeNavigator: ComposeNavigator
) {
    LazyVerticalGrid(
        modifier = Modifier.background(Color.White),
        columns = GridCells.Fixed(gridSize),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        content = {
            items(items) { item ->
                CardComponent(modifier = Modifier.background(Purple700), icon = item.icon, name = item.name, onClick = {
                    composeNavigator.navigate(item.screen)
                })
            }
        }
    )
}
