package com.khalore.features.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.khalore.core.base.MviState

@Composable
fun LocationsScreen(
    viewModel: LocationsViewModel = hiltViewModel()
) {
    val viewState by viewModel.viewState
    LocationListContent(viewState.state)
}

@Composable
fun LocationListContent(
    viewMviState: MviState<LocationsViewState>,
) {
    when (viewMviState) {
        is MviState.Data -> LocationList(
            locations = viewMviState.data.locations
        )

        is MviState.Error -> {}
        is MviState.Loading -> {}
        is MviState.None -> {}
    }
}

