@file:OptIn(ExperimentalMaterialApi::class)

package com.project.student.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.student.localdata.DashboardNavDetails
import com.project.student.ui.theme.Purple700

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardComponent(
    modifier: Modifier = Modifier.padding(vertical = 8.dp),
    icon: ImageVector,
    name: String,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .padding(10.dp)
            .height(148.dp),
        elevation = 10.dp,
        backgroundColor = Purple700,
        shape = MaterialTheme.shapes.large,
        onClick = onClick
    ) {
        Column(
            modifier = modifier
                .padding(10.dp)
                .height(148.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "Icon",
                modifier = modifier.size(48.dp)
            )
            Text(
                text = name,
                textAlign = TextAlign.Center,
                fontSize = 22.sp
            )
        }
    }
}
