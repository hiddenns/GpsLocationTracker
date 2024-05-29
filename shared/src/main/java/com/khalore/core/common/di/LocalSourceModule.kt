package com.khalore.core.common.di

import com.khalore.core.local.datasource.LocationLocalDataSource
import com.khalore.core.local.datasource.LocationLocalDataSourceImpl
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