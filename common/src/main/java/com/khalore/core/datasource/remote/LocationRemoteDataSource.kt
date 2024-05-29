package com.khalore.core.datasource.remote

import com.khalore.core.model.GpsLocation

interface LocationRemoteDataSource {

    suspend fun syncLocation(locations: List<GpsLocation>): Result<Unit>

}