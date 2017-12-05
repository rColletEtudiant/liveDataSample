package com.rcollet.livedataproject.data

import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepository @Inject constructor(var taskDao: TaskDao) {
  fun getTasks(): Single<List<Task>> = taskDao.getTasks()
  fun createTask(task: Task): Completable = taskDao.createTask(task)
  fun deleteTask(task: Task): Completable = taskDao.deleteTask(task)
}