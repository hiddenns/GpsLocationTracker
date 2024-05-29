package com.khalore.core.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.khalore.core.local.dao.LocationDao
import com.khalore.core.local.entity.LocationEntity

@Database(entities = [LocationEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun locationDao(): LocationDao
}
