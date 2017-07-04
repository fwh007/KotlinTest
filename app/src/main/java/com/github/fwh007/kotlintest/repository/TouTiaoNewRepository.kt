package com.github.fwh007.kotlintest.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.github.fwh007.kotlintest.model.BaseCallback
import com.github.fwh007.kotlintest.model.BaseResponse
import com.github.fwh007.kotlintest.model.New
import com.github.fwh007.kotlintest.service.NewService
import java.util.*

/**
 * TODO 类说明
 *
 * @author : Winter
 */

class TouTiaoNewRepository : NewRepository() {

    val newService = retrofit.create(NewService::class.java)!!
    val newDetailCache: WeakHashMap<Long, New> = WeakHashMap()

    override fun getNewDetail(id: Long): LiveData<New> {
        val data = MutableLiveData<New>()
        if (newDetailCache.containsKey(id)) {
            data.value = newDetailCache[id]
        } else {
            newService.detail(id).enqueue(object : BaseCallback<New>() {
                override fun onResponse(response: BaseResponse<New>?) {
                    val result = response?.data
                    if (result != null) {
                        result.item_id = id
                        newDetailCache.put(id, result)
                    }
                    data.value = response?.data
                }
            })
        }
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