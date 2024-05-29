package com.khalore.core.di

import com.khalore.core.datasource.local.location.LocationLocalDataSource
import com.khalore.core.datasource.local.location.LocationLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface LocalSourceModule {

    @Singleton
    @Binds
    fun bindsLocationDataSource(
        locationLocalDataSource: LocationLocalDataSourceImpl
    ): LocationLocalDataSource


}