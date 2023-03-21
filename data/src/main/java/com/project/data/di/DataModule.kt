package com.project.data.di

import android.content.Context
import androidx.room.Room
import com.project.data.repository.StudentRepositoryImpl
import com.project.data.sources.local.Dao
import com.project.data.sources.local.VvceConnectDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideVvceDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, VvceConnectDatabase::class.java, "vvce_database").build()

    @Singleton
    @Provides
    fun provideDao(vvceConnectDatabase: VvceConnectDatabase) = vvceConnectDatabase.getDao()

    @Singleton
    @Provides
    fun provideStudentRepository(dao: Dao) = StudentRepositoryImpl(dao)
}
