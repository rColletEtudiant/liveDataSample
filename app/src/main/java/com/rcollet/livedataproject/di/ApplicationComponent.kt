package com.rcollet.livedataproject.di

import com.rcollet.livedataproject.view.HomeActivity
import com.rcollet.livedataproject.TaskApplication
import dagger.Component
import javax.inject.Singleton

/**
 * Created by robincollet on 02/12/2017.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class, HomeModule::class))
interface ApplicationComponent {
  fun inject(taskApplication: TaskApplication)
  fun inject(homeActivity: HomeActivity)
}