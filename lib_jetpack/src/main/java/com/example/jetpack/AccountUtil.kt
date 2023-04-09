package com.example.jetpack

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.thread.ThreadPoolUtil

object AccountUtil {

    fun getUser(userId: String): LiveData<User> {

        val userLiveData = MutableLiveData<User>()
        ThreadPoolUtil.execute {
            Thread.sleep(1000)
            userLiveData.postValue(User(userId, 10))
        }
        return userLiveData
    }
}