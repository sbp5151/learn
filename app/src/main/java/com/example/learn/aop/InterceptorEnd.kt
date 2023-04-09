package com.example.learn.aop

import android.util.Log

class InterceptorEnd : MyInterceptor {
    companion object {
        const val TAG = "InterceptorEnd"
    }

    override fun intercept(chain: MyChain): MyResult {
        chain.request.body += "end"
        Log.d(TAG, "intercept request body:${chain.request.body}")
        return MyResult("end_")
    }
}