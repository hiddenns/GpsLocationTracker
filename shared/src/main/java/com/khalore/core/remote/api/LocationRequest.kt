package com.khalore.core.remote.api

import com.google.gson.annotations.SerializedName
import com.khalore.core.common.model.GpsLocation

data class LocationsRequest(
    @SerializedName("locations") val locations: List<LocationRequest>
)

data class LocationRequest(
    @SerializedName("locationId") val locationId: Long,
    @SerializedName("latitude") val latitude: Double,
    @SerializedName("longitude") val longitude: Double,
    @SerializedName("timestamp") val timestamp: Long = System.currentTimeMillis()
)

fun GpsLocation.toRequest(): LocationRequest {
    return LocationRequest(
        locationId = locationId,
        latitude = latitude,
        longitude = longitude,
        timestamp = timestamp
    )
}