package com.geeks.hw_2_m7

class TaskValidator {
    fun validateTaskName(name:String,existingNames:List<String>):String?{
        return if (name.isBlank()) {
            "Название задачи не можеть быть пустым."
        }else if (existingNames.contains(name)) {
            "Задача с таким названием уже существует."
        }else {
           null
        }
    }
    fun validateTaskDate(date: Long): String?{
        return if (date < System.currentTimeMillis()) {
            "Дата задачи не можеть быть в прошлом."
        }else {
            null
        }
    }
}