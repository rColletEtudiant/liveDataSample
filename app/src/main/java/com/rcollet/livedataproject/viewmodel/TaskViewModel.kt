package com.rcollet.livedataproject.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.annotation.MainThread
import com.rcollet.livedataproject.data.Task
import com.rcollet.livedataproject.data.TaskRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by robincollet on 02/12/2017.
 */

@Singleton
class TaskViewModel @Inject constructor(var taskRepository: TaskRepository) : ViewModel() {
    private val disposables: CompositeDisposable = CompositeDisposable()
    var tasks: MutableLiveData<List<Task>> = MutableLiveData()

    fun loadTasks() {
        disposables.add(taskRepository.getTasks()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t ->  tasks.setValue(t)
            })
        )
    }

    fun deleteTask(task: Task){ loadTasks()} //= taskRepository.deleteTask(task)
    fun createTask(task: Task){ loadTasks()}// = taskRepository.createTask(task)

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}