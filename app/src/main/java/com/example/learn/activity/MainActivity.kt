package com.example.learn.activity

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.*
import android.util.Log
import androidx.annotation.InspectableProperty
import androidx.appcompat.app.AppCompatActivity
import com.example.learn.R
import com.example.learn.handler.MyHandlerThread
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    private var myHandler: MyHandler? = null
    private var myThread: MyHandlerThread? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myThread = MyHandlerThread()
        myThread!!.start()
    }


    internal class MyHandler(looper: Looper) : Handler(looper) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            Log.d(TAG, "MyHandlerMessage ${Thread.currentThread().name} ${msg.obj}")
        }
    }

    fun newHandler(view: android.view.View) {
//        myThread?.looper?.let {
//            myHandler = MyHandler(it)
//        }
//        val intent = Intent(this, NextActivity::class.java)
//        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//        startActivity(intent)

        val intent = Intent()
        intent.setClassName("com.example.jetpackdemo", "com.example.jetpackdemo.MainActivity")
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    private val random = Random(10)
    fun sendMessage(view: android.view.View) {
//        myHandler?.let {
//            val msg = it.obtainMessage()
//            msg.obj = random.nextInt()
//            it.sendMessage(msg)
//        }
//        printTask()
        val intent = Intent(this, MainActivity3::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    fun printTask() {
        val am: ActivityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val rts = am.getRunningTasks(5)
        rts?.let {
            for (rt in it) {
                Log.d(TAG, "print task ${rt.topActivity?.className}")
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }
}