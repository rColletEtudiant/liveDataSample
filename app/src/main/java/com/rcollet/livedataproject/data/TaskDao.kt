package com.rcollet.livedataproject.data

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by robincollet on 02/12/2017.
 */

@Dao
interface TaskDao {
  @Query("SELECT * FROM task")
  fun getTasks(): Single<List<Task>>
  @Delete
  fun deleteTask(task: Task) : Completable
  @Insert(onConflict = REPLACE)
  fun createTask(task: Task) : Completable
}
