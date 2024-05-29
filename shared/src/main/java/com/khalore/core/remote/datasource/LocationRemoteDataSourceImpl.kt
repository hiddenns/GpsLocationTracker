package com.khalore.core.remote.datasource

import com.khalore.core.common.model.GpsLocation
import com.khalore.core.remote.api.LocationApi
import com.khalore.core.remote.api.LocationsRequest
import com.khalore.core.remote.api.toRequest
import javax.inject.Inject

class LocationRemoteDataSourceImpl @Inject constructor(
    private val api: LocationApi
) : LocationRemoteDataSource {

    override suspend fun syncLocation(locations: List<GpsLocation>) = runCatching {
        api.syncLocation(
            LocationsRequest(
                locations = locations.map { gpsLocation ->
                    gpsLocation.toRequest()
                }
            )
        )
    }

}