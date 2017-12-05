package com.rcollet.livedataproject

import android.app.Application
import com.rcollet.livedataproject.di.ApplicationComponent
import com.rcollet.livedataproject.di.ApplicationModule
import com.rcollet.livedataproject.di.DaggerApplicationComponent
import com.rcollet.livedataproject.di.HomeModule

/**
 * Created by robincollet on 02/12/2017.
 */

class TaskApplication : Application() {

  val applicationComponent: ApplicationComponent by lazy {
    DaggerApplicationComponent
      .builder()
      .applicationModule(ApplicationModule(this))
      .homeModule(HomeModule(this))
      .build()
  }

  override fun onCreate() {
    super.onCreate()
    applicationComponent.inject(this)
  }

  fun applicationComponent() : ApplicationComponent = applicationComponent
}