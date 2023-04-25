package com.project.student.localdata

object CheckBoxSubjectData {

    fun getSubjectData():List<CheckBoxSubjectDetails>{
        val subjectDataList : List<CheckBoxSubjectDetails> = listOf(
            CheckBoxSubjectDetails(
                subjectId = "18CS61",
                subjectName = "System Software and Compiler Design"
            ),
            CheckBoxSubjectDetails(
                subjectId = "18CS62",
                subjectName = "Computer Graphics"
            ),
            CheckBoxSubjectDetails(
                subjectId = "18CS63",
                subjectName = "Web Technologies"
            ),
            CheckBoxSubjectDetails(
                subjectId = "18CS64",
                subjectName = "Data Mining and Data Warehouse"
            ),
        )
        return subjectDataList
    }
}