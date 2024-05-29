package com.khalore.core.datasource.remote.template

import javax.inject.Inject

class TemplateRemoteDataSourceImpl @Inject constructor(
    private val api: Template
) : TemplateRemoteDataSource {

    override suspend fun getTranslate(
        source: String,
        target: String,
        word: String
    ): Result<Unit> {
        return Result.success(Unit)
    }
}