package com.khalore.core.api.location

import retrofit2.http.Body
import retrofit2.http.POST

interface LocationApi {

    @POST(SYNC_LOCATIONS)
    suspend fun syncLocation(@Body request: LocationsRequest)

    companion object {
        private const val SYNC_LOCATIONS = "/sync"
    }
}