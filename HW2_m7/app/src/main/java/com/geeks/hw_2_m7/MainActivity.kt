package com.geeks.hw_2_m7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.geeks.hw_2_m7.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var addTaskUseCase: AddTaskUseCase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val taskValidator = TaskValidator()
        val taskRepository = TaskRepositoryImpl(
            Room.databaseBuilder(applicationContext, AppDatabase::class.java, "task_db" )
                .build()
                .taskDao()
        )
        binding.btnAddTask.setOnClickListener{
            val taskName = binding.etTaskName.text.toString()
            val taskDate = Calendar.getInstance().apply {
                set(binding.datePicker.year, binding.datePicker.month,binding.datePicker.dayOfMonth)
            }.timeInMillis
            lifecycleScope.launch {
                val result = addTaskUseCase.addTask(taskName,taskDate)
                if(result.isFailure) {
                    Toast.makeText(this@MainActivity,result.exceptionOrNull()?.message,Toast.LENGTH_SHORT).show()
                }else {
                    Toast.makeText(this@MainActivity, "Задача добавлена", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}