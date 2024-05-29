package com.khalore.core.local.datasource

import com.khalore.core.common.model.GpsLocation
import kotlinx.coroutines.flow.Flow


interface LocationLocalDataSource {

    fun getLocations(): Flow<List<GpsLocation>>

    suspend fun getLocationsCount(): Result<Long>

    suspend fun getLastPageLocations(pageSize: Long): Result<List<GpsLocation>>

    suspend fun saveLocation(gpsLocation: GpsLocation): Result<Long>

}