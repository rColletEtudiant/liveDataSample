package com.rcollet.livedataproject

import android.app.Activity

/**
 * Created by robincollet on 03/12/2017.
 */

val Activity.app: TaskApplication
  get() = application as TaskApplication