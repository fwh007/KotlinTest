package com.github.fwh007.kotlintest

import android.arch.lifecycle.MutableLiveData

/**
 * TODO 类说明
 *
 * @author : Winter
 */

class UserRepository{
    fun getUser(userId: Int): MutableLiveData<User> {
        val data:MutableLiveData<User> = MutableLiveData()
        val user = User(userId, "Feng", "Winter")
        data.value = user
        return data
    }
}