package com.project.domain.di

import com.project.domain.repository.StudentRepository
import com.project.domain.usecases.GetStudentUseCase
import com.project.domain.usecases.InsertStudentUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideGetStudentUseCase(repository: StudentRepository) = GetStudentUseCase(repository)

    @Singleton
    @Provides
    fun provideInsertStudentUseCase(repository: StudentRepository) = InsertStudentUseCase(repository)
}