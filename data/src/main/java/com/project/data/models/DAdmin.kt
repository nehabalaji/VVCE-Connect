package com.project.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DAdmin(
    @PrimaryKey
    val id: Int,
    val name: String,
    val email: String,
    val password: String
)
