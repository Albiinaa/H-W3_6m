package com.geeks.hw_2_m7

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val date: Long
)
