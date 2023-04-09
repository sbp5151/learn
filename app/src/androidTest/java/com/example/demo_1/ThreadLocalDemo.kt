package com.example.learn

import android.util.Log
import com.example.thread.ThreadPoolUtil
import com.example.thread.ThreadPoolUtil.submit
import org.junit.Test
import java.util.*
import java.util.concurrent.Callable
import java.util.concurrent.FutureTask
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock
import java.util.concurrent.locks.ReentrantReadWriteLock

class ThreadLocalDemo {

    @Volatile
    private var intA = 0
    private var intB = 100
    private val mObjectLock = Object()
    private val mReentrantLock = ReentrantLock()
    private val mRWLock = ReentrantReadWriteLock()
    private val mReadLock = mRWLock.readLock()
    private val mWriteLock = mRWLock.writeLock()

    companion object {
        const val TAG = "ThreadLocalDemo"
    }

    @Test
    fun threadPool() {
        Log.d(TAG, "threadPool start")
        //execute runnable
        ThreadPoolUtil.execute {
            Log.d(TAG, "execute +++++${Thread.currentThread().name}")
            Thread.sleep(1000)
            Log.d(TAG, "execute wake ------${Thread.currentThread().name}")
        }

        //execute futureTask
        val futureTask = FutureTask {
            Log.d(TAG, "futureTask call +++++${Thread.currentThread().name}")
            Thread.sleep(1000)
            Log.d(TAG, "futureTask call wake ------${Thread.currentThread().name}")
            "futureTask result"
        }
        ThreadPoolUtil.execute(futureTask)
        val futureTaskResult = futureTask.get()
        Log.d(TAG, "futureTaskResult: $futureTaskResult")

        //submit runnable
        val future1 = submit {
            Log.d(TAG, "submit run +++++${Thread.currentThread().name}")
            Thread.sleep(1000)
            Log.d(TAG, "submit run wake ------${Thread.currentThread().name}")
        }
        val submitResult = future1?.get()
        Log.d(TAG, "submitResult $submitResult")

        //submit callable
        val future2 = submit(Callable {
            Log.d(TAG, "submit2 run +++++${Thread.currentThread().name}")
            mReentrantLock.lock()
            Thread.sleep(1000)
            mReentrantLock.unlock()
            Log.d(TAG, "submit2 run ------${Thread.currentThread().name}")
            "submit 2"
        })
        val submitResult2 = future2.get()
        Log.d(TAG, "submitResult2 $submitResult2")
    }


    @Test
    fun threadLocal1() {

        val threadLocalA = ThreadLocal<String>()
        val threadLocalB = ThreadLocal<String>()
        var intC = 0
        Thread {
//            threadLocalA.set("thread1 set string A1")
//            threadLocalB.set("thread1 set string B1")

            while (intB > 0) {
                intB--
                Log.d(TAG, "Thread1 intB :$intB")
            }
        }.start()

        Thread {
//            Log.d(TAG, "threadLocalA 1 :${threadLocalA.get()}")
//            Log.d(TAG, "threadLocalB 1 :${threadLocalB.get()}")

            while (intB > 0) {
                intB--
                Log.d(TAG, "Thread2 intB :$intB")
            }
        }.start()
    }
}