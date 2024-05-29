package com.khalore.features.screens.home

import com.khalore.core.common.base.ViewEvent
import com.khalore.core.common.base.ViewSideEffect
import com.khalore.core.common.base.ViewState
import com.khalore.core.common.model.GpsLocation
import com.khalore.core.common.base.MviState as BaseState

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