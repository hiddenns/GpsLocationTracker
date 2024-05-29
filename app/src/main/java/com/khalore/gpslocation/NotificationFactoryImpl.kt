package com.khalore.gpslocation

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.khalore.core.notification.NotificationFactory
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class NotificationFactoryImpl @Inject constructor(
    @ApplicationContext
    private val context: Context
): NotificationFactory {

    companion object {
        private const val LOCATION_CHANNEL_ID = "LocationForegroundServiceChannel"
    }

    override fun getLocationServiceNotification(): Notification {
        createNotificationChannel()

        val notificationIntent = Intent(context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            context, 0, notificationIntent,
            PendingIntent.FLAG_IMMUTABLE
        )

        return NotificationCompat.Builder(context, LOCATION_CHANNEL_ID)
            .setContentTitle("Location Service")
            .setContentText("Service is running")
            .setSmallIcon(androidx.core.R.drawable.ic_call_answer)
            .setContentIntent(pendingIntent)
            .build()
    }

    private fun createNotificationChannel() {
        val serviceChannel = NotificationChannel(
            LOCATION_CHANNEL_ID,
            "Location Foreground Service Channel",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        val manager = context.getSystemService(NotificationManager::class.java)
        manager?.createNotificationChannel(serviceChannel)
    }

}