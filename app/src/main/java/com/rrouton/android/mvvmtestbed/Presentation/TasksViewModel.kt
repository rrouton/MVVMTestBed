package com.rrouton.android.mvvmtestbed.Presentation

import androidx.lifecycle.ViewModel
import com.rrouton.android.mvvmtestbed.Data.Models.Task
import com.rrouton.android.mvvmtestbed.Data.TaskRepository

class TasksViewModel(private val taskRepository: TaskRepository)
    : ViewModel() {

    fun getTasks() = taskRepository.getTasks()

    fun addTask(task: Task) =  taskRepository.addTask(task)

}