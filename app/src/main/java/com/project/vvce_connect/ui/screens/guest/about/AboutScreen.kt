package com.project.vvce_connect.ui.screens.guest.about

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.text.TextStyle
import com.project.vvce_connect.ui.screens.components.ButtonComponent
import com.project.vvce_connect.ui.screens.components.TextComponent
import com.project.vvce_connect.ui.screens.components.TextFieldComponent

@Composable
fun AboutScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        TextComponent(text = "Established in 1997, VVCE is an autonomous institute affiliated to" +
                " Visvesvaraya Technological University (VTU), Belagavi, approved by AICTE & UGC, New Delhi and " +
                "recognized by Govt. of Karnataka. Six UG programs are accredited by National Board of Accreditation, " +
                "New Delhi. VVCE is also accredited by NAAC with “A” grade. VVCE offers seven UG programs, " +
                "three PG programs and nine Research Centres for pursuing PhD programs, with a total student population" +
                " of over 3200. The college has excellent infrastructure coupled with qualified and passionate faculty team " +
                "to provide a perfect learning ambience. The college is under the able leadership of Dr. B. Sadashive Gowda, " +
                "PhD (IISc) as Principal, who has rich experience in industry and education" +
                " fields both in India and abroad.", 
            modifier = Modifier, style = TextStyle())
        ButtonComponent(text = "Read more")
    }
    }
}
}