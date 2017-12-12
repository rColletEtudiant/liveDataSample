package com.rcollet.livedataproject.view

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.rcollet.livedataproject.R
import com.rcollet.livedataproject.util.app
import com.rcollet.livedataproject.viewmodel.TaskViewModel
import javax.inject.Inject

class DetailsActivity : AppCompatActivity() {

  @Inject
  lateinit var taskViewModel: TaskViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_details)
    app.applicationComponent().inject(this)
    taskViewModel.tasks.observe(this, Observer {
      Toast.makeText(this, it!!.first().description, Toast.LENGTH_LONG).show()
    })
  }
}
