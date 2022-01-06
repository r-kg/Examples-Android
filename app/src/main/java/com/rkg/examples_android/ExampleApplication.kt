package com.rkg.examples_android

import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ExampleApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }
}