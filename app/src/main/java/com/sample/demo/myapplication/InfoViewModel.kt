package com.sample.demo.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InfoViewModel(var infoRepository: InfoRepository): ViewModel() {
    private var userInfoLiveData = MutableLiveData<UserData>()
    fun callInfo():LiveData<UserData>{
        infoRepository.loadInfo(object : OnTaskFinish {
            override fun onFinish(data: UserData) {
                userInfoLiveData.postValue(data)
            }
        })
        return userInfoLiveData
    }
}