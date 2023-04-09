package com.example.learn.handler

import android.os.Looper

class MyHandlerThread : Thread() {

    var looper: Looper? = null
    override fun run() {
        super.run()
        print("MyHandlerThread run3")
        Looper.prepare()

        looper = Looper.myLooper()

        Looper.loop()
    }
}