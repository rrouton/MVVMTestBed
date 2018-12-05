package com.rrouton.android.mvvmtestbed.Presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rrouton.android.mvvmtestbed.Data.TaskRepository

class TasksViewModelFactory(private val taskRepository: TaskRepository)
    :ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TasksViewModel(taskRepository) as T
    }

}
