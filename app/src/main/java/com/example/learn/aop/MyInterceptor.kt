package com.example.learn.aop

interface MyInterceptor {
    fun intercept(chain: MyChain):MyResult
}