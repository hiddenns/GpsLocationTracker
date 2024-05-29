package com.khalore.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.khalore.core.dao.LocationDao
import com.khalore.core.entity.LocationEntity

@Database(entities = [LocationEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun locationDao(): LocationDao
}
