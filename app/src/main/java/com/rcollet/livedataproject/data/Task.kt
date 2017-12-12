package com.rcollet.livedataproject.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by robincollet on 02/12/2017.
 */
@Entity(tableName = "task")
data class Task(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var description: String,
    var completed: Boolean = false
)