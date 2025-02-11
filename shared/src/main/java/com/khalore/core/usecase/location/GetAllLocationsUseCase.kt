package com.khalore.core.usecase.location

import com.khalore.core.common.di.IODispatcher
import com.khalore.core.repository.location.LocationRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetAllLocationsUseCase @Inject constructor(
    private val locationRepository: LocationRepository,
    @IODispatcher
    private val dispatcher: CoroutineDispatcher
) {

    operator fun invoke() = locationRepository.getLocations()
        .flowOn(dispatcher)

}