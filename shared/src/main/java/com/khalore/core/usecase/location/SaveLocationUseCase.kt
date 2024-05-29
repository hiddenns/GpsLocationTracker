package com.khalore.core.usecase.location

import com.khalore.core.common.di.IODispatcher
import com.khalore.core.common.model.GpsLocation
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