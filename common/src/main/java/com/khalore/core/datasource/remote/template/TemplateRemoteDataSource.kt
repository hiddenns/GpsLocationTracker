package com.khalore.core.datasource.remote.template

interface TemplateRemoteDataSource {

    suspend  fun getTranslate(
        source: String,
        target: String,
        word: String,
    ): Result<Unit>

}