package com.khalore.features.components.location

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.khalore.core.ext.TimeFormatter
import com.khalore.core.model.GpsLocation

@Composable
fun LocationItem(location: GpsLocation) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = "ID: ${location.locationId}")
            Text(text = "Latitude: ${location.latitude}")
            Text(text = "Longitude: ${location.longitude}")
            Text(text = "Time: ${TimeFormatter.formatHhMmDdMmYyyy(location.timestamp)}")
        }
    }
}

@Preview
@Composable
fun LocationItemPreview() {
    val location = GpsLocation(
        latitude = 48.23,
        longitude = 46.34
    )

    LocationItem(location = location)
}