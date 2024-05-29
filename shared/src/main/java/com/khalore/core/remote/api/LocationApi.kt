package com.khalore.core.remote.api

import retrofit2.http.Body
import retrofit2.http.POST

interface LocationApi {

    @POST(SYNC_LOCATIONS)
    suspend fun syncLocation(@Body request: LocationsRequest)

    companion object {
        private const val SYNC_LOCATIONS = "/sync"
    }
}