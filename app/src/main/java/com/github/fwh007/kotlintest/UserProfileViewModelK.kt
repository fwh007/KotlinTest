package com.github.fwh007.kotlintest

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel

/**
 * TODO 类说明
 *
 * @author : Winter
 */

class UserProfileViewModelK : ViewModel() {
    var userId: String? = null
    var user: LiveData<User>? = null

    fun init(userId: String?) {
        this.userId = userId
    }
}