package com.project.data.sources.local

import androidx.room.Dao
import androidx.room.Query
import com.project.data.model.DStudent

@Dao
interface Dao {

    @Query("SELECT * FROM DStudent WHERE usn=:usn")
    fun getStudent(usn: String): DStudent
}
