package com.geeks.hw_2_m7

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(
    entities = [TaskEntity:: class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao
}