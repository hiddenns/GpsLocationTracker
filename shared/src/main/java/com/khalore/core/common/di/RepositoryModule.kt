package com.khalore.core.common.di


import com.khalore.core.repository.location.LocationRepository
import com.khalore.core.repository.location.LocationRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindsLocationRepository(
        locationRepository: LocationRepositoryImpl
    ): LocationRepository

}