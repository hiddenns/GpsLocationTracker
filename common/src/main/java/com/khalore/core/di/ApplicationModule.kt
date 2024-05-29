package com.khalore.core.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ApplicationModule {

//    @Binds
//    fun bindsAnalyticManager(impl: AnalyticManagerImpl): AnalyticManager
//
//
//    companion object {
//        @Singleton
//        @Provides
//        fun providesRemoteConfig() = RemoteConfigManager.create()
//
//        @Singleton
//        @Provides
//        fun provideFirebaseAnalytic(@ApplicationContext context: Context) =
//            FirebaseAnalytics.getInstance(context)
//
//    }

}