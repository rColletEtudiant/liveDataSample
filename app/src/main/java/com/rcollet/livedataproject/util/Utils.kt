package com.rcollet.livedataproject.util

import android.app.Activity
import com.rcollet.livedataproject.TaskApplication

/**
 * Created by robincollet on 03/12/2017.
 */

val Activity.app: TaskApplication
  get() = application as TaskApplication