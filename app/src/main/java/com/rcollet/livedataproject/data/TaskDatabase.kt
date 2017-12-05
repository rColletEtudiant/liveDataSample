package com.rcollet.livedataproject.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by robincollet on 02/12/2017.
 */

@Database(entities = arrayOf(Task::class), version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {
  abstract fun taskDao(): TaskDao
}