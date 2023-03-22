package com.project.vvce_connect.ui.screens.guest.department

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.project.vvce_connect.ui.screens.components.BoxInBox
import com.project.vvce_connect.ui.screens.components.DepartmentGrid
import com.project.vvce_connect.ui.screens.localdata.DepartmentCourseDetails
import com.project.vvce_connect.ui.screens.localdata.DepartmentData
import com.project.vvce_connect.ui.screens.localdata.DepartmentDetails

@Composable
fun DepartmentScreen(
    modifier: Modifier,
    departmentList: List<DepartmentDetails>,
    gridSize: Int,
    items: List<DepartmentCourseDetails>
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        BoxInBox(modifier = modifier, text = "Department", subject = departmentList[0].departmentName.toString())
        DepartmentGrid(gridSize = gridSize, items = items, modifier = modifier)
    }
}

@Preview
@Composable
fun DepartmentScreenPreview() {
    DepartmentScreen(modifier = Modifier, departmentList = DepartmentData.getDepartmentItems(), gridSize = 2 , items = DepartmentData.getUGItems())
}
