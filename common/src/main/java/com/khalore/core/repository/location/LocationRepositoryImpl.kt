package com.khalore.core.repository.location

import com.khalore.core.datasource.local.location.LocationLocalDataSource
import com.khalore.core.datasource.remote.LocationRemoteDataSource
import com.khalore.core.model.GpsLocation
import javax.inject.Inject
import javax.inject.Singleton

// TODO INTERNAL ALL CLASSES
@Singleton
class LocationRepositoryImpl @Inject constructor(
    private val local: LocationLocalDataSource,
    private val remote: LocationRemoteDataSource
) : LocationRepository {

    override fun getLocations() = local.getLocations()

    override suspend fun getLocationsCount() = local.getLocationsCount()

    override suspend fun getLastPageLocations(pageSize: Long) = local.getLastPageLocations(pageSize)

    override suspend fun syncLocation(locations: List<GpsLocation>) =
        remote.syncLocation(locations)

    override suspend fun saveLocation(gpsLocation: GpsLocation) =
        local.saveLocation(gpsLocation)

}