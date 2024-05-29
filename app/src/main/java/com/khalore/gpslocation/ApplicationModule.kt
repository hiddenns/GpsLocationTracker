package com.khalore.gpslocation

import com.khalore.core.common.notification.NotificationFactory
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface ApplicationModule {

    @Binds
    fun notificationFactory(notificationFactoryImpl: NotificationFactoryImpl): NotificationFactory

}