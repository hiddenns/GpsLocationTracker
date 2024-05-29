package com.khalore.features.screens.home

import com.khalore.core.base.BaseViewModel
import com.khalore.core.base.State
import com.khalore.core.repository.template.TemplateRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TemplateViewModel @Inject constructor(
    private val templateRepository: TemplateRepository
) : BaseViewModel<
        TemplateContract.Event,
        TemplateContract.State,
        TemplateContract.Effect>() {

    override fun setInitialState() = TemplateContract.State(State.Loading)

    override fun handleEvents(event: TemplateContract.Event) {
        when (event) {
            is TemplateContract.Event.SetupCards -> {

            }
        }
    }

}