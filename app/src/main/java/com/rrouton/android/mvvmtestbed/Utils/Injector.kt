package com.rrouton.android.mvvmtestbed.Utils

import com.rrouton.android.mvvmtestbed.Data.Database
import com.rrouton.android.mvvmtestbed.Data.TaskRepository
import com.rrouton.android.mvvmtestbed.Presentation.TasksViewModelFactory


object Injector {

    fun provideTasksViewModelFactory() : TasksViewModelFactory {
        val taskRepository = TaskRepository.getInstance(Database.getInstance().taskDao)
        return TasksViewModelFactory(taskRepository)
    }
}