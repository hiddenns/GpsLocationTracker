package com.khalore.core.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TemplateLocal(
    @PrimaryKey(autoGenerate = true)
    val test: Long
)