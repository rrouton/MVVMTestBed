package com.rrouton.android.mvvmtestbed.Presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.rrouton.android.mvvmtestbed.Data.Models.Task
import com.rrouton.android.mvvmtestbed.R
import com.rrouton.android.mvvmtestbed.Utils.Injector
import kotlinx.android.synthetic.main.activity_todo.*
import java.lang.StringBuilder

class TodoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        initializeUi()
    }

    private fun initializeUi() {
        val factory = Injector.provideTasksViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(TasksViewModel::class.java)

        viewModel.getTasks().observe(this, Observer { tasks ->
            val stringBuilder = StringBuilder()
            tasks.forEach { task ->
                stringBuilder.append("$task\n\n")
            }
            tasksTextView.text = stringBuilder.toString()
        })

        addTasksButton.setOnClickListener {
            val task = Task(editTextTask.text.toString())
            editTextTask.setText("")
            viewModel.addTask(task)
        }
    }
}
