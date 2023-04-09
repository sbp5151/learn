package com.example.learn.aop

import android.util.Log
import kotlin.random.Random

class Interceptor1 : MyInterceptor {

    companion object {
        const val TAG = "Interceptor_1"
    }

    override fun intercept(chain: MyChain): MyResult {
        Log.d(TAG, "intercept start: ")
        chain.request.body += "body1_${Random(System.currentTimeMillis()).nextInt(0,100)}_"
        val result = chain.process()
        result.body += "body1_${Random(System.currentTimeMillis()).nextInt(0,100)}_"
        Log.d(TAG, "intercept end: ")
        return result
    }
}