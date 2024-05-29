package com.khalore.features.location

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.google.android.gms.location.LocationServices
import com.khalore.core.model.GpsLocation
import com.khalore.core.notification.NotificationFactory
import com.khalore.core.usecase.SaveLocationUseCase
import com.khalore.core.usecase.SyncLocationUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class LocationService : Service() {

    companion object {
        private const val GET_LOCATION_DELAY = 1000L * 5
        private const val NOTIFICATION_ID = 1001
    }

    @Inject
    lateinit var saveLocationUseCase: SaveLocationUseCase

    @Inject
    lateinit var syncLocationUseCase: SyncLocationUseCase

    @Inject
    lateinit var notificationFactory: NotificationFactory

    private val coroutineScope = CoroutineScope(Dispatchers.Main.immediate + SupervisorJob())

    private val fusedLocationClient by lazy {
        LocationServices.getFusedLocationProviderClient(this)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val notification = notificationFactory.getLocationServiceNotification()
        startForeground(NOTIFICATION_ID, notification)
        startObserveLocation()
        return START_NOT_STICKY
    }


    @SuppressLint("MissingPermission")
    private fun startObserveLocation() {
        coroutineScope.launch {
            while (true) {
                delay(GET_LOCATION_DELAY)
                val location = fusedLocationClient.getCurrentLocation()
                val latitude = location?.latitude
                val longitude = location?.longitude

                processLocation(latitude, longitude)
            }
        }
    }

    private suspend fun processLocation(latitude: Double?, longitude: Double?): Boolean {
        val nonNullLatitude = latitude ?: return false
        val nonNullLongitude = longitude ?: return false

        Log.d("anal", "processLocation: $nonNullLongitude $nonNullLatitude")
        val gspLocation = GpsLocation(
            latitude = nonNullLatitude,
            longitude = nonNullLongitude
        )

        saveLocationUseCase(gspLocation).onSuccess {
            syncLocationUseCase()
        }

        return true
    }



    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

}