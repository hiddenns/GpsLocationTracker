package com.khalore.core.notification

import android.app.Notification

interface NotificationFactory {

    fun getLocationServiceNotification(): Notification

}