package com.khalore.features.screens.home

import com.khalore.core.base.ViewEvent
import com.khalore.core.base.ViewSideEffect
import com.khalore.core.base.ViewState
import com.khalore.core.model.GpsLocation
import com.khalore.core.base.MviState as BaseState

class LocationScreenContract {
    sealed class Event : ViewEvent {

        data class SetupLocations(
            val locations: List<GpsLocation>
        ) : Event()

    }

    data class State(
        val state: BaseState<LocationsViewState>
    ) : ViewState

    sealed class Effect : ViewSideEffect {}
}