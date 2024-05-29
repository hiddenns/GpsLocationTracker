package com.khalore.core.usecase.location

import com.khalore.core.common.di.IODispatcher
import com.khalore.core.repository.location.LocationRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetLocationsCountUseCase @Inject constructor(
    private val locationRepository: LocationRepository,
    @IODispatcher
    private val dispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke() = withContext(dispatcher) {
        locationRepository.getLocationsCount()
    }
}