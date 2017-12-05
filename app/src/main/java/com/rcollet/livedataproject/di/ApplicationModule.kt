package com.rcollet.livedataproject.di

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by robincollet on 02/12/2017.
 */
@Module
class ApplicationModule(private val taskApplication: Application) {
  @Provides
  @Singleton
  fun provideApplication(): Application = taskApplication
}