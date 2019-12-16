package com.sample.demo.myapplication

import java.util.concurrent.Executors

class InfoRepository {
    fun loadInfo(task: OnTaskFinish) {
        Executors.newSingleThreadExecutor().submit {
            val userData = UserData()
            userData.userName = "jake"
            userData.userAge = 30
            Thread.sleep(3000)
            task.onFinish(userData)
        }
    }
}
interface OnTaskFinish {
    fun onFinish(data: UserData)
}