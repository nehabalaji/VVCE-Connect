package com.project.vvce_connect.ui.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GuestCardComponent(modifier: Modifier, icon: ImageVector,text:String) {
    Card(
        modifier = modifier
            .padding(10.dp)
            .height(240.dp)
            .width(150.dp)
            .verticalScroll(rememberScrollState()),
        elevation = 10.dp,
        backgroundColor = MaterialTheme.colors.background,
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            IconImageComponent(
                modifier = modifier.align(Alignment.Start).size(36.dp),
                image = icon,
                content = "Logo",
            )
            TextComponent(
                text = text,
                modifier = modifier,
                style = TextStyle(fontSize = 24.sp),
            )
        }
    }
}

@Preview
@Composable
fun GuestCardComponentPreview() {
    GuestCardComponent(modifier = Modifier, icon = Icons.Filled.Lightbulb, text = "30+ student-led clubs to expand knowledge domain")
}
