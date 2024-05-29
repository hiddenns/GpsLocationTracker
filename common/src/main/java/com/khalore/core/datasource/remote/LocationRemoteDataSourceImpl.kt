package com.khalore.core.datasource.remote

import com.khalore.core.api.location.LocationApi
import com.khalore.core.api.location.LocationsRequest
import com.khalore.core.api.location.toRequest
import com.khalore.core.model.GpsLocation
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