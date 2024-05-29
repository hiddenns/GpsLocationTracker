package com.khalore.core.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.khalore.core.local.entity.LocationEntity
import kotlinx.coroutines.flow.Flow
@Dao
interface LocationDao {

    @Query("SELECT * FROM LocationEntity ORDER BY timestamp DESC")
    fun getLocations() : Flow<List<LocationEntity>>

    @Query("SELECT COUNT(*) FROM LocationEntity")
    suspend fun getLocationsCount() : Long

    @Query("SELECT * FROM LocationEntity ORDER BY timestamp DESC LIMIT :pageSize")
    suspend fun getLastPageLocations(pageSize: Long) : List<LocationEntity>

    @Insert
    suspend fun saveLocation(location: LocationEntity): Long

}