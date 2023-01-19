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
import com.project.vvce_connect.ui.screens.student.StudentNavData
import com.project.vvce_connect.ui.screens.student.StudentNavDetails

@Composable
fun FeaturesGridComponent(
    gridSize: Int,
    items: List<StudentNavDetails>,
    modifier: Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        content = {
            items(items) { item ->
                CardComponent(modifier = modifier, icon = item.icon, name = item.name)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun FeaturesGridComponentPreview() {
    FeaturesGridComponent(gridSize = 2, items = StudentNavData.getFeatureGridItems(), modifier = Modifier)
}
