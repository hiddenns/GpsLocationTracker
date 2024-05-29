package com.khalore.core.usecase

import com.khalore.core.di.IODispatcher
import com.khalore.core.model.GpsLocation
import com.khalore.core.repository.location.LocationRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SaveLocationUseCase @Inject constructor(
    private val locationRepository: LocationRepository,
    @IODispatcher
    private val dispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(gpsLocation: GpsLocation) = withContext(dispatcher) {
        locationRepository.saveLocation(gpsLocation)
    }
}