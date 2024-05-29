package com.khalore.features.screens.home

import com.khalore.core.base.ViewEvent
import com.khalore.core.base.ViewSideEffect
import com.khalore.core.base.ViewState
import com.khalore.core.base.State as BaseState

class TemplateContract {
    sealed class Event : ViewEvent {

        data class SetupCards(
            val cards: List<Unit>
        ) : Event()

    }

    data class State(
        val state: BaseState<CollectionViewState>
    ) : ViewState

    sealed class Effect : ViewSideEffect {}
}