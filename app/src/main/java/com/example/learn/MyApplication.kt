package com.example.learn

import android.app.Activity
import android.app.Application
import android.app.Application.ActivityLifecycleCallbacks
import android.os.Bundle
import com.squareup.leakcanary.LeakCanary

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        LeakCanary.install(this)
    }
}