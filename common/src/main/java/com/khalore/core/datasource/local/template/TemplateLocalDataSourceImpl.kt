package com.khalore.core.datasource.local.template

import com.khalore.core.dao.TemplateDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class TemplateLocalDataSourceImpl @Inject constructor(
    private val templateDao: TemplateDao
) : TemplateLocalDataSource {

    override fun getCardsFlow(): Flow<Unit> {
        return flowOf(Unit)
    }

}