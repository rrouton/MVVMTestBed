package com.rrouton.android.mvvmtestbed.Data

import com.rrouton.android.mvvmtestbed.Data.Models.Task

class TaskRepository private constructor(private val taskDao: TaskDao) {

    fun addTask(task: Task) {
        taskDao.addTask(task)
    }

    fun getTasks() = taskDao.getTasks()

    companion object {
        @Volatile private var INSTANCE: TaskRepository? = null

        //Double-checked lock
        fun getInstance(taskDao: TaskDao) =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: TaskRepository(taskDao).also { INSTANCE = it }
            }

    }
}