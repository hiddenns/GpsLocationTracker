package com.khalore.core.common.notification

import android.app.Notification

interface NotificationFactory {

    fun getLocationServiceNotification(): Notification

}