package com.geeks.hw_2_m7

import java.lang.Exception

interface TaskRepository {
    suspend fun getAllTasks(): List<TaskEntity>
     suspend fun insertTask(task: TaskEntity)
    }
 class TaskRepositoryImpl(private val dao: TaskDao): TaskRepository{
     override suspend fun getAllTasks() = dao.getAllTasks()
     override suspend fun insertTask(task: TaskEntity) = dao.insertTask(task)
 }
