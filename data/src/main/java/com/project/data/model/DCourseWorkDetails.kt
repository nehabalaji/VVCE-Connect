package com.project.data.model // ktlint-disable filename

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DCourseWorkDetails(
    val name: String,
    val date: String,
    val link:String,
    val type: String,
    val course: String,
    val sem: String,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L
)
