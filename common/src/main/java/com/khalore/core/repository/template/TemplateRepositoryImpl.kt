package com.khalore.core.repository.template

import com.khalore.core.datasource.local.template.TemplateLocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TemplateRepositoryImpl @Inject constructor(
    private val templateLocalDataSource: TemplateLocalDataSource
) : TemplateRepository {

    override fun getCardsFlow(): Flow<Unit> {
        return templateLocalDataSource.getCardsFlow()
    }

}