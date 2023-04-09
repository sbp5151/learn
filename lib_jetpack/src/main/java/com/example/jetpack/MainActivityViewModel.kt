package com.example.jetpack

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.thread.ThreadPoolUtil
import kotlin.random.Random

class MainActivityViewModel : ViewModel() {

    companion object {
        const val TAG = "MainActivityViewModel"
    }

    private val mMutableLiveData: MutableLiveData<User> by lazy {
        MutableLiveData<User>()
    }

    //将不可变liveData暴露给外部
    val mUserLiveData: LiveData<User> get() = mMutableLiveData

    //转换liveData map
    val uUserNameLiveData: LiveData<String> = Transformations.map(mMutableLiveData) {
        it.name
    }

    //转换liveData switchMap
    private val mInputLiveData = MutableLiveData<String>()
    val mSwitchUserLiveData:LiveData<User> = Transformations.switchMap(mInputLiveData){
        AccountUtil.getUser(it)
    }

    fun getUser(userId:String){
        mInputLiveData.postValue(userId)
    }

    fun loadUser() {
        ThreadPoolUtil.execute{
            Thread.sleep(1000)
            val random = Random(10)
            mMutableLiveData.postValue(User("单一为", random.nextInt(1, 10)))
        }
    }
}