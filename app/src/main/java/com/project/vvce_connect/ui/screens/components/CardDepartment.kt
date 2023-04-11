package com.project.vvce_connect.ui.screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.vvce_connect.R

@Composable
fun CardDepartment(modifier: Modifier, course: String, logo: Int) {
    Card(
        modifier = modifier
            .padding(10.dp)
            .height(148.dp)
            .verticalScroll(rememberScrollState()),
        elevation = 10.dp,
        backgroundColor = MaterialTheme.colors.background
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ImageComponent(
                painter = painterResource(id = logo),
                content = "Department Logo",
                modifier = modifier.size(80.dp)
            )
            TextComponent(
                text = course,
                modifier = modifier,
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp) )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardDepartmentPreview() {
    CardDepartment(modifier = Modifier, course = "C S E", logo = R.drawable.vvce_logo_splash)
}
