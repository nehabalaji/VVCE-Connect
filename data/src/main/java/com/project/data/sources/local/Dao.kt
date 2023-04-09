package com.project.data.sources.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.project.data.model.DStudent

@Dao
interface Dao {

    @Query("SELECT * FROM DStudent WHERE emailId=:email")
    fun getStudent(email: String): DStudent?

    @Insert
    suspend fun insertStudent(student: DStudent)
}
