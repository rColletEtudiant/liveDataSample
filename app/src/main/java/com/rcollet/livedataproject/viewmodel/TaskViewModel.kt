package com.rcollet.livedataproject.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.rcollet.livedataproject.data.Task
import com.rcollet.livedataproject.data.TaskRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by robincollet on 02/12/2017.
 */

@Singleton
class TaskViewModel @Inject constructor(var taskRepository: TaskRepository): ViewModel() {

    var tasks: LiveData<List<Task>>

    init {
        tasks = loadTasks()
    }

    fun loadTasks() = taskRepository.getTasks()
    fun deleteTask(task: Task) = taskRepository.deleteTask(task)
    fun createTask(task: Task) = taskRepository.createTask(task)
    fun updateTask(task: Task) = taskRepository.updateTask(task)
}