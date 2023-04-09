package com.example.learn

import android.app.Activity
import java.lang.ref.ReferenceQueue
import java.lang.ref.WeakReference

object MyLeakCanary {

    val map = HashMap<Activity,ReferenceQueue<Activity>>()

    fun add(activity:Activity){

    }
}