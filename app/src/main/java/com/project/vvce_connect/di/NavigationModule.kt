package com.project.vvce_connect.di

import com.project.navigator.ComposeNavigator
import com.project.navigator.composenavigator.VvceConnectComposeNavigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NavigationModule {

    @Binds
    @Singleton
    abstract fun provideComposeNavigator(whatsappCloneComposeNavigator: VvceConnectComposeNavigator): ComposeNavigator
}
