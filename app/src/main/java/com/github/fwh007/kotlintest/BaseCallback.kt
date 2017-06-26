package com.github.fwh007.kotlintest

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * TODO 类说明
 *
 * @author : Winter
 */

abstract class BaseCallback<T> : Callback<BaseResponse<T>> {
    override fun onResponse(call: Call<BaseResponse<T>>?, response: Response<BaseResponse<T>>?) {
        onResponse(response?.body())
    }

    override fun onFailure(call: Call<BaseResponse<T>>?, t: Throwable?) {
        //统一处理错误
    }

    abstract fun onResponse(response: BaseResponse<T>?)
}