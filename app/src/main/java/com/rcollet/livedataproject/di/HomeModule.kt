package com.rcollet.livedataproject.di

import android.app.Application
import android.arch.persistence.room.Room
import com.rcollet.livedataproject.data.TaskDao
import com.rcollet.livedataproject.data.TaskDatabase
import com.rcollet.livedataproject.data.TaskRepository
import com.rcollet.livedataproject.viewmodel.TaskViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by robincollet on 03/12/2017.
 */
@Module
class HomeModule(private val taskApplication: Application) {

  val taskDatabase: TaskDatabase by lazy {
    Room.databaseBuilder(taskApplication, TaskDatabase::class.java, "Task.db"
    ).allowMainThreadQueries().build()
  }

  @Provides
  @Singleton
  fun provideTaskRepository(taskDao: TaskDao): TaskRepository = TaskRepository(taskDao)

  @Provides
  @Singleton
  fun provideTaskDao(taskDatabase: TaskDatabase): TaskDao = taskDatabase.taskDao()

  @Provides
  @Singleton
  fun provideTaskDatabase(application: Application): TaskDatabase = taskDatabase

  @Provides
  @Singleton
  fun provideTaskViewModel(taskRepository: TaskRepository): TaskViewModel = TaskViewModel(taskRepository)
}