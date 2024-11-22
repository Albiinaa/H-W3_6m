package com.geeks.hw_2_m7

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TaskDao {
   @Query("SELECT * FROM tasks")
   suspend fun getAllTasks():List<TaskEntity>
   @Insert
   suspend fun insertTask(task:TaskEntity)
}