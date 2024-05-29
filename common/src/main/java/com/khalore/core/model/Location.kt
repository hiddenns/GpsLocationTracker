package com.khalore.core.model

data class GpsLocation(
    val locationId: Long = -1,
    val latitude: Double,
    val longitude: Double,
    val timestamp: Long = System.currentTimeMillis()
)