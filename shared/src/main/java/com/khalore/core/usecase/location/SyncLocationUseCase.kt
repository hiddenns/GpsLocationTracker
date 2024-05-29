package com.khalore.core.usecase.location

import com.khalore.core.common.di.IODispatcher
import com.khalore.core.repository.location.LocationRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SyncLocationUseCase @Inject constructor(
    private val locationRepository: LocationRepository,
    @IODispatcher
    private val dispatcher: CoroutineDispatcher
) {

    companion object {
        private const val COUNT_FOR_SYNC = 10L
    }

    suspend operator fun invoke() = withContext(dispatcher) {
        locationRepository.getLocationsCount().onSuccess { count ->
            if (count % COUNT_FOR_SYNC == 0L) {
                locationRepository.getLastPageLocations(COUNT_FOR_SYNC).onSuccess { locations ->
                    locationRepository.syncLocation(locations)
                }
            }
        }
    }

}