package com.example.learn.handler

import android.os.Looper

class MyRunnable:Runnable {

    override fun run() {
        Looper.prepare()

        Looper.loop()
    }
}