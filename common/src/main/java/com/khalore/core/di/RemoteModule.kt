package com.khalore.core.di

import com.khalore.core.datasource.remote.LocationRemoteDataSource
import com.khalore.core.datasource.remote.LocationRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RemoteModule {

    @Singleton
    @Binds
    fun bindsLocationRemoteDataSource(
        locationRemoteDataSource: LocationRemoteDataSourceImpl
    ): LocationRemoteDataSource

}