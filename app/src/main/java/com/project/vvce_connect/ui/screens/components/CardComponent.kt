package com.project.vvce_connect.ui.screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardComponent(modifier: Modifier, icon: ImageVector, name: String) {
    Card(
        modifier = modifier
            .padding(10.dp)
            .height(148.dp),
        elevation = 10.dp,
        backgroundColor = MaterialTheme.colors.background,
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(imageVector = icon,
                contentDescription = "Icon",
                modifier = modifier.size(48.dp)
            )
            Text(
                text = name,
                textAlign = TextAlign.Center,
                fontSize = 24.sp
            )
        }
    }
}

@Preview
@Composable
fun CardComponentPreview() {
    CardComponent(modifier = Modifier, icon = Icons.Filled.Person, name = "Profile")
}
