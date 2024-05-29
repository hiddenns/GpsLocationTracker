package com.khalore.core.common.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MainDispatcher

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IODispatcher

@Module
@InstallIn(SingletonComponent::class)
internal interface CoroutineModule {
    companion object {

        @MainDispatcher
        @Provides
        fun provideMainDispatcher() = Dispatchers.Main

        @IODispatcher
        @Provides
        fun provideIoDispatcher() = Dispatchers.IO
    }
}