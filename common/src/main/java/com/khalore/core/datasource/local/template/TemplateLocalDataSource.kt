package com.khalore.core.datasource.local.template

import kotlinx.coroutines.flow.Flow

interface TemplateLocalDataSource {

    fun getCardsFlow(): Flow<Unit>

}