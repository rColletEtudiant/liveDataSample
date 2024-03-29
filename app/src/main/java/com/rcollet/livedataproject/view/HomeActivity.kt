package com.rcollet.livedataproject.view

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.inputmethod.EditorInfo
import android.widget.LinearLayout
import com.rcollet.livedataproject.R
import com.rcollet.livedataproject.app
import com.rcollet.livedataproject.data.Task
import com.rcollet.livedataproject.viewmodel.TaskViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

  @Inject
  lateinit var taskViewModel: TaskViewModel

  private var taskAdapter: TaskAdapter? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    app.applicationComponent().inject(this)
    setupAdapter()
    setupListener()
    setupObserver()
  }

  private fun setupObserver() {
    taskViewModel.tasks.observe(this, Observer {
      taskAdapter!!.fill(it!!)
    })
  }

  private fun setupAdapter() {
    taskAdapter = TaskAdapter(ArrayList(), { task, bool ->
      task.completed = bool
      taskViewModel.createTask(task)
    },{taskViewModel.deleteTask(it)})
    task_list.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
    task_list.adapter = taskAdapter
  }

  private fun setupListener() {
    task_input.setOnEditorActionListener { v, actionId, event ->
      if(actionId == EditorInfo.IME_ACTION_SEND) {
        taskViewModel.createTask(Task(v.text.toString()))
        true
      } else {
        false
      }
    }
  }
}

