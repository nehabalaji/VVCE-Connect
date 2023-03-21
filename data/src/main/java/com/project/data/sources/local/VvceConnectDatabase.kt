package com.project.data.sources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project.data.model.DStudent

@Database(
    entities = [DStudent::class],
    version = 1,
    exportSchema = false
)
abstract class VvceConnectDatabase: RoomDatabase() {
    abstract fun getDao(): Dao
}