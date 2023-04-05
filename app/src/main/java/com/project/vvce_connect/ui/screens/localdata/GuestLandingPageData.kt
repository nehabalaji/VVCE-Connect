package com.project.vvce_connect.ui.screens.localdata

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*

object GuestLandingPageData {

    fun getLandingPageData(): List<GuestLandingPageDetails> {
        val landingPageData = listOf<GuestLandingPageDetails>(
            GuestLandingPageDetails(
                name = "Entrepreneurial ambiance with free startup facilities",
                icon = Icons.Outlined.Crop169,
            ),
            GuestLandingPageDetails(
                name = "A blend of conventional and project-based learning",
                icon = Icons.Outlined.CoPresent,
            ),
            GuestLandingPageDetails(
                name = "30+ student-led clubs to expand knowledge domain",
                icon = Icons.Outlined.Lightbulb,
            ),
            GuestLandingPageDetails(
                name = "Autonomous institute with industry relevant curriculum",
                icon = Icons.Outlined.MilitaryTech,
            ),
            GuestLandingPageDetails(
                name = "Accredited by NBA & NAAC with \"A\" Grade",
                icon = Icons.Outlined.AutoAwesome,
            ),
            GuestLandingPageDetails(
                name = "National & International placements",
                icon = Icons.Outlined.School,
            ),
        )

        return landingPageData
    }
}
