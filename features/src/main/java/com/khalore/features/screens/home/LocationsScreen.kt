package com.khalore.features.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.khalore.core.common.base.MviState

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
        is MviState.None -> EmptyContent()
    }
}

@Composable
fun EmptyContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        BasicText(
            text = "Empty location list",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}