package com.github.fwh007.kotlintest

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

/**
 * TODO 类说明
 *
 * @author : Winter
 */

abstract class NewRepository {

    abstract fun getNewDetail(id: Long): LiveData<New>

    abstract fun getNewList(tag: String, startTime: Date): LiveData<List<New>>
}