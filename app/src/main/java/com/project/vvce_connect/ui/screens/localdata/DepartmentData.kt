package com.project.vvce_connect.ui.screens.localdata

import androidx.compose.ui.res.painterResource
import com.project.vvce_connect.R

object DepartmentData {

    fun getDepartmentItems(): List<DepartmentDetails> {
        val departmentItemList = listOf<DepartmentDetails>(
            DepartmentDetails(
                departmentName = "Undergraduate"
            ),
            DepartmentDetails(
                departmentName = "Postgraduate"
            ),
            DepartmentDetails(
                departmentName = "Basic Sciences"
            ),
            DepartmentDetails(
                departmentName = "Humanities"
            ),
            DepartmentDetails(
                departmentName = "Library"
            ),
            DepartmentDetails(
                departmentName = "Placements"
            ),
            DepartmentDetails(
                departmentName = "R & D"
            )
        )

        return departmentItemList
    }

    fun getUGItems(): List<DepartmentCourseDetails> {
        val ugItemList = listOf<DepartmentCourseDetails>(
            DepartmentCourseDetails(
                department = "Undergraduate",
                course = "AI & ML",
                logo = R.drawable.vvce_logo
            ),
            DepartmentCourseDetails(
                department = "Undergraduate",
                course = "C S E ",
                logo = R.drawable.vvce_logo
            ),
            DepartmentCourseDetails(
                department = "Undergraduate",
                course = "I S E",
                logo = R.drawable.vvce_logo
            ),
            DepartmentCourseDetails(
                department = "Undergraduate",
                course = "Mechanical",
                logo = R.drawable.vvce_logo
            ),
            DepartmentCourseDetails(
                department = "Undergraduate",
                course = "Civil",
                logo = R.drawable.vvce_logo
            ),
            DepartmentCourseDetails(
                department = "Undergraduate",
                course = "E C E",
                logo = R.drawable.vvce_logo
            ),
            DepartmentCourseDetails(
                department = "Undergraduate",
                course = "Electrical",
                logo = R.drawable.vvce_logo
            ),
        )

        return ugItemList
    }

    fun getPGItems():List<DepartmentCourseDetails>{
        val pgItemList = listOf<DepartmentCourseDetails>(
            DepartmentCourseDetails(
                department = "Postgraduate",
                course = "M B A",
                logo = R.drawable.vvce_logo
            ),
            DepartmentCourseDetails(
                department = "Postgraduate",
                course = "M.Tech CSE",
                logo = R.drawable.vvce_logo
            ),
            DepartmentCourseDetails(
                department = "Postgraduate",
                course = "M.Tech Robotics",
                logo = R.drawable.vvce_logo
            ),

        )
        return pgItemList
    }

    fun getBasicScienceItems():List<DepartmentCourseDetails> {
        val bsItemList = listOf<DepartmentCourseDetails>(
            DepartmentCourseDetails(
                department = "Basic Sciences",
                course = "Physics",
                logo = R.drawable.vvce_logo
            ),
            DepartmentCourseDetails(
                department = "Basic Sciences",
                course = "Mathematics",
                logo = R.drawable.vvce_logo
            ),
            DepartmentCourseDetails(
                department = "Basic Sciences",
                course = "Chemistry",
                logo = R.drawable.vvce_logo
            )
        )
        return bsItemList
    }

    fun getHumanitiesItems():List<DepartmentCourseDetails>{
        val humanityItemList = listOf<DepartmentCourseDetails>(
            DepartmentCourseDetails(
                department = "Humanities",
                course = "humanities",
                logo = R.drawable.vvce_logo
            )
        )
        return humanityItemList
    }

    fun getLibraryItems():List<DepartmentCourseDetails>{
        val libraryItemList = listOf<DepartmentCourseDetails>(
            DepartmentCourseDetails(
                department = "Library",
                course = "library",
                logo = R.drawable.vvce_logo
            )
        )

        return libraryItemList
    }

    fun getPlacementItems():List<DepartmentCourseDetails>{
        val placementItemList = listOf<DepartmentCourseDetails>(
            DepartmentCourseDetails(
                department = "Placements",
                course = "TAP",
                logo = R.drawable.vvce_logo
            )
        )
        return placementItemList
    }

    fun getRnDItems():List<DepartmentCourseDetails>{
        val rndItemList = listOf<DepartmentCourseDetails>(
            DepartmentCourseDetails(
                department = "R & D",
                course = "Research",
                logo = R.drawable.vvce_logo
            )
        )
        return rndItemList
    }
}
