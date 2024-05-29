package com.khalore.core.repository.template

import kotlinx.coroutines.flow.Flow

interface TemplateRepository {

    fun getCardsFlow(): Flow<Unit>

}