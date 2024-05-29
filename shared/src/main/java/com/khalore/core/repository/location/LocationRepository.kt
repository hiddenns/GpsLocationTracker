package com.khalore.core.repository.location

import com.khalore.core.common.model.GpsLocation
import kotlinx.coroutines.flow.Flow

interface LocationRepository {

    fun getLocations(): Flow<List<GpsLocation>>

    suspend fun getLocationsCount(): Result<Long>

    suspend fun getLastPageLocations(pageSize: Long): Result<List<GpsLocation>>

    suspend fun syncLocation(locations: List<GpsLocation>): Result<Unit>

    suspend fun saveLocation(gpsLocation: GpsLocation): Result<Long>

}