package com.khalore.core.common.di

import com.khalore.core.remote.datasource.LocationRemoteDataSource
import com.khalore.core.remote.datasource.LocationRemoteDataSourceImpl
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