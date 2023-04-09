package com.example.learn.aop

import android.util.Log

object MyDispatcher {

    private const val TAG = "MyDispatcher"

    fun execute(): MyResult {
        Log.d(TAG, "execute: ")
        val interceptors = mutableListOf<MyInterceptor>()
        interceptors += Interceptor1()
        interceptors += Interceptor2()
        interceptors += InterceptorEnd()
        val chain = MyChain(interceptors = interceptors, request = MyRequest())
        return chain.process()
    }
}