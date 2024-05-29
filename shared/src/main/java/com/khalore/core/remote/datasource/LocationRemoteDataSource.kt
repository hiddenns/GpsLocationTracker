package com.khalore.core.remote.datasource

import com.khalore.core.common.model.GpsLocation

interface LocationRemoteDataSource {

    suspend fun syncLocation(locations: List<GpsLocation>): Result<Unit>

}