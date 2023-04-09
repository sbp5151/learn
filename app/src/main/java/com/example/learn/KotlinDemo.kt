package com.example.learn

import android.util.Log

class KotlinDemo {
    fun demo() {
        val person = Person("男")
        person.age = 2
        person.name = "shanyiwei"
        person.sleep()

        val student = Student()
        student.grade = 1002
        student.id = 13
        student.gotoSchool()

        val list = listOf("张三", "李四")
        val mutableList = mutableListOf("张三", "李四", "王五")
        mutableList.add("赵六")
        mutableList.removeAt(0)
        mutableList[2] = "老王"
        for (i in mutableList) {
            Log.d("TAG", i)
        }

        val set = setOf("张三", "李四")
        var mutableSet = mutableSetOf("张三", "李四", "王五")

        var map = mapOf(1 to "张三", 2 to "李四")
        var mutableMap = mutableMapOf(1 to "张三", 2 to "李四", 3 to "王五")

        mutableMap[4] = "赵六"
        mutableMap.remove(0)
        mutableMap[2] = "老王"
        for ((key, value) in mutableMap) {
            Log.d("TAG", "$key : $value")
        }

        val lambda = {fruit:String -> fruit.length}
        set.maxByOrNull(lambda)
    }
}