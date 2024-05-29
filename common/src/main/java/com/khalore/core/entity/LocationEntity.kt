package com.khalore.core.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.khalore.core.model.GpsLocation

@Entity
data class LocationEntity(
    @PrimaryKey(autoGenerate = true)
    val locationId: Long = 0,
    val latitude: Double,
    val longitude: Double,
    val timestamp: Long = System.currentTimeMillis() // TODO
)

internal fun LocationEntity.toDomain(): GpsLocation {
    return GpsLocation(
        locationId = locationId,
        longitude = longitude,
        latitude = latitude,
        timestamp = timestamp
    )
}

internal fun GpsLocation.toEntity(): LocationEntity {
    return LocationEntity(
        longitude = longitude,
        latitude = latitude,
        timestamp = timestamp
    )
}

