package com.rcollet.livedataproject.util

import android.support.annotation.Nullable
import android.support.v7.util.DiffUtil
import com.rcollet.livedataproject.data.Task

/**
 * Created by robincollet on 06/12/2017.
 */

class TaskListDiffCallback(val oldTasks: List<Task>,var newTasks: List<Task>) : DiffUtil.Callback() {

  override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
    return oldTasks[oldItemPosition].id == newTasks[newItemPosition].id
  }

  override fun getOldListSize(): Int = oldTasks.size

  override fun getNewListSize(): Int = newTasks.size

  override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
    return oldTasks[oldItemPosition] == newTasks[newItemPosition]
  }

  @Nullable
  override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
    return super.getChangePayload(oldItemPosition, newItemPosition)
  }
}