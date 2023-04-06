package com.project.student.ui.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun IconButtonComponent(icon:ImageVector,content:String) {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = icon, contentDescription = content)
    }
}

@Preview
@Composable
fun IconButtonComponentPreview() {
    IconButtonComponent(icon = Icons.Filled.Done, content = "Tick Icon" )
}
