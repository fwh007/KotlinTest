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

class TouTiaoNewRepository : NewRepository() {

    lateinit var newService: NewService

    override fun getNewDetail(id: Long): LiveData<New> {
        val data = MutableLiveData<New>()
        newService.detail(id).enqueue(object : BaseCallback<New>() {
            override fun onResponse(response: BaseResponse<New>?) {
                data.value = response?.data
            }
        })
        return data
    }

    override fun getNewList(tag: String, startTime: Date): LiveData<List<New>> {
        val data = MutableLiveData<List<New>>()
        newService.list(tag, startTime).enqueue(object : BaseCallback<List<New>>() {
            override fun onResponse(response: BaseResponse<List<New>>?) {
                data.value = response?.data
            }
        })
        return data
    }
}