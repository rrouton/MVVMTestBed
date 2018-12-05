package com.rrouton.android.mvvmtestbed.Data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rrouton.android.mvvmtestbed.Data.Models.Task

    class TaskDao {
    private val taskList = mutableListOf<Task>()
    private val tasks = MutableLiveData<List<Task>>()

    init {
        tasks.value = taskList
    }

    fun addTask(task: Task) {
        taskList.add(task)
        //Triggers observables
        tasks.value = taskList
    }

    fun getTasks() = tasks as LiveData<List<Task>>
}
