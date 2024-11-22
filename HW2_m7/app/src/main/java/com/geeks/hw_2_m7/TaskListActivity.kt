package com.geeks.hw_2_m7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.geeks.hw_2_m7.databinding.ActivityTaskListBinding

class TaskListActivity: AppCompatActivity() {
    private lateinit var binding: ActivityTaskListBinding
    private lateinit var taskAdapter: TaskAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        loadTasks()
    }
    private fun setupRecyclerView(){
        taskAdapter = TaskAdapter(emptyList())
        binding.rvTasks.apply {
            layoutManager = LinearLayoutManager(this@TaskListActivity)
            adapter = taskAdapter
        }
    }
    private fun loadTasks(){
        val dummyTasks = listOf(
            TaskEntity(1, "Задача 1", System.currentTimeMillis()),
            TaskEntity(2, "Задача 2", System.currentTimeMillis() + 86400000)
        )
        taskAdapter = TaskAdapter(dummyTasks)
        binding.rvTasks.adapter = taskAdapter
    }
}