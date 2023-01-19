package com.project.vvce_connect.ui.screens.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TopAppBarComponent(modifier: Modifier, title: String) {
    TopAppBar(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.secondary,
        elevation = 10.dp,
        contentPadding = AppBarDefaults.ContentPadding
    ) {
        Text(
            text = title,
            modifier = modifier.padding(10.dp),
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun TopAppBarComponentPreview() {
    TopAppBarComponent(modifier = Modifier, title = "Hello Neha")
}
