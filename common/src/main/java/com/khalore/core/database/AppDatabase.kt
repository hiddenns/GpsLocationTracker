package com.khalore.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.khalore.core.dao.TemplateDao
import com.khalore.core.entity.TemplateLocal

@Database(entities = [TemplateLocal::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun templateDao(): TemplateDao
}
