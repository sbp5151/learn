package com.example.learn.aop

import android.util.Log
import java.util.*
import kotlin.random.Random

class Interceptor2 : MyInterceptor {

    companion object {
        const val TAG = "Interceptor_2"
    }

    override fun intercept(chain: MyChain): MyResult {
        Log.d(TAG, "intercept start: ")
        chain.request.body += "body2_${Random(UUID.randomUUID().variant()).nextInt(0,100)}_"
        val result = chain.process()
        result.body += "body2_${Random(UUID.randomUUID().variant()).nextInt(0,100)}_"
        Log.d(TAG, "intercept end: ")
        return result
    }
}