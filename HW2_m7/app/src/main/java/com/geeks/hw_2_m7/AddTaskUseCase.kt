package com.geeks.hw_2_m7

class AddTaskUseCase (
    private val taskRepository: TaskRepository,
    private val validator: TaskValidator
) {
    suspend fun addTask(name: String, date: Long):Result<Unit> {
        val existingTasks = taskRepository.getAllTasks()
        val nameError = validator.validateTaskName(name,existingTasks.map { it.name })
        if (nameError != null) return Result.failure(Exception(nameError))

        val dateError = validator.validateTaskDate(date)
        if (dateError != null) return Result.failure(Exception(dateError))

        taskRepository.insertTask(TaskEntity(name = name, date = date))
        return Result.success(Unit)
    }
}