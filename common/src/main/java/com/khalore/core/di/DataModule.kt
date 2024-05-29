package com.khalore.core.di


import com.khalore.core.repository.template.TemplateRepository
import com.khalore.core.repository.template.TemplateRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Singleton
    @Binds
    abstract fun bindsTemplateRepository(
        templateRepository: TemplateRepository
    ): TemplateRepositoryImpl

}