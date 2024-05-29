package com.khalore.core.dao

import androidx.room.Dao
import androidx.room.Query
import com.khalore.core.entity.TemplateLocal
import kotlinx.coroutines.flow.Flow

@Dao
interface TemplateDao {

    @Query("SELECT * FROM TemplateLocal")
    fun getCardsFlow(): Flow<List<TemplateLocal>>

}