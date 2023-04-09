package com.example.learn.aop

class MyChain(
    private var index: Int = 0,
    var interceptors: List<MyInterceptor>,
    var request: MyRequest
) {

    fun process(): MyResult {
        val interceptor = interceptors[index]
        index++
        return interceptor.intercept(this)
    }
}