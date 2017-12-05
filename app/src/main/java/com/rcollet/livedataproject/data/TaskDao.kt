package com.rcollet.livedataproject.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE

/**
 * Created by robincollet on 02/12/2017.
 */

@Dao
interface TaskDao {
  @Query("SELECT * FROM task")
  fun getTasks(): LiveData<List<Task>>
  @Delete
  fun deleteTask(task: Task)
  @Insert(onConflict = REPLACE)
  fun createTask(task: Task)
}
