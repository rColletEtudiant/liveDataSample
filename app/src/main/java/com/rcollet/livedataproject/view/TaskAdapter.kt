package com.rcollet.livedataproject.view

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rcollet.livedataproject.R
import com.rcollet.livedataproject.data.Task
import com.rcollet.livedataproject.util.TaskListDiffCallback
import kotlinx.android.synthetic.main.item_task.view.*

/**
 * Created by robincollet on 03/12/2017.
 */

class TaskAdapter(var tasks: List<Task>, val completeListener: (Task, Boolean) -> Unit, val longClickListener: (Task) -> Unit) : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

  fun fill(newtasks: List<Task>) {
    var diffRes: DiffUtil.DiffResult = DiffUtil.calculateDiff(TaskListDiffCallback(tasks, newtasks))
    diffRes.dispatchUpdatesTo(this)
    this.tasks = tasks
  }
  override fun onBindViewHolder(holder: ViewHolder?, position: Int)  = holder!!.bindItems(tasks[position], completeListener, longClickListener)

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
    val v = LayoutInflater.from(parent!!.context).inflate(R.layout.item_task, parent, false)
    return ViewHolder(v)
  }

  override fun getItemCount() = tasks.size

  class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var task: Task? = null
    fun bindItems(task: Task, completeListener: (Task, Boolean) -> Unit, longClickListener: (Task) -> Unit) {
      this.task = task
      with(task) {
        itemView.task_name.text = task.description
        itemView.task_check.isChecked = task.completed
        itemView.task_check.setOnCheckedChangeListener {
          _ ,checked -> completeListener(task, checked)
        }
        itemView.setOnLongClickListener { longClickListener(task); true}
      }
    }
  }
}