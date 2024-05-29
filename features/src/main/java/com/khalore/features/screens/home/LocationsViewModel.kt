package com.khalore.features.screens.home

import androidx.lifecycle.viewModelScope
import com.khalore.core.base.BaseViewModel
import com.khalore.core.base.MviState
import com.khalore.core.model.GpsLocation
import com.khalore.core.usecase.GetAllLocationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationsViewModel @Inject constructor(
    private val getAllLocationsUseCase: GetAllLocationsUseCase
) : BaseViewModel<
        LocationScreenContract.Event,
        LocationScreenContract.State,
        LocationScreenContract.Effect>() {

    init {
        fetchLocations()
    }

    override fun setInitialState() = LocationScreenContract.State(MviState.Loading)

    override fun handleEvents(event: LocationScreenContract.Event) {
        when (event) {
            is LocationScreenContract.Event.SetupLocations -> {
                setupLocations(event.locations)
            }
        }
    }

    private fun fetchLocations() {
        viewModelScope.launch {
            getAllLocationsUseCase().collect { locations ->
                handleEvents(
                    LocationScreenContract.Event.SetupLocations(
                        locations = locations
                    )
                )
            }
        }
    }

    private fun setupLocations(locations: List<GpsLocation>) {
        viewModelScope.launch {
            if (locations.isEmpty()) {
                setState { LocationScreenContract.State(MviState.None) }
                return@launch
            }
            setState {
                LocationScreenContract.State(
                    MviState.Data(
                        LocationsViewState(
                            locations = locations
                        )
                    )
                )
            }
        }
    }

}