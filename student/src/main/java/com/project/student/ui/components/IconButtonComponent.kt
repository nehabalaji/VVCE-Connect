package com.project.student.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun IconButtonComponent(icon:ImageVector,content:String) {
    IconButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(10.dp)) {
        Icon(imageVector = icon, contentDescription = content)
    }
}

@Preview
@Composable
fun IconButtonComponentPreview() {
    IconButtonComponent(icon = Icons.Filled.Done, content = "Tick Icon" )
}
