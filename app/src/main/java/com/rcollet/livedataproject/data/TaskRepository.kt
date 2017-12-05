package com.rcollet.livedataproject.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepository @Inject constructor(var taskDao: TaskDao) {
  fun getTasks() = taskDao.getTasks()
  fun createTask(task: Task) = taskDao.createTask(task)
  fun deleteTask(task: Task) = taskDao.deleteTask(task)
}