package com.project.student.ui.timetable

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.student.ui.timetable.viewmodel.TimetableViewModel
import com.rizzi.bouquet.ResourceType
import com.rizzi.bouquet.VerticalPDFReader
import com.rizzi.bouquet.rememberVerticalPdfReaderState

@Composable
fun TimetableScreen(
    context: Context,
    timetableViewModel: TimetableViewModel = hiltViewModel()
) {
    val timetableLink by timetableViewModel.timetableLink.collectAsState()
    val timetableUrl by timetableLink.collectAsState(initial = "")

    if (timetableUrl.isNotEmpty()) {
        val pdfState = rememberVerticalPdfReaderState(
            resource = ResourceType.Remote(timetableUrl),
            isZoomEnable = true
        )

        VerticalPDFReader(
            state = pdfState,
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Gray)
        )
    } else {
        Text(text = "Please wait till we find your timetable..")
    }
}
