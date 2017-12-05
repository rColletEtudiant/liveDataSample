package com.rcollet.livedataproject.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by robincollet on 02/12/2017.
 */
@Entity(tableName = "task")
data class Task(var description: String, var completed: Boolean = false,
   @PrimaryKey(autoGenerate = true) var id: Long = 0)