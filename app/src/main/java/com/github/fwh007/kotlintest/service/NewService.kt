package com.github.fwh007.kotlintest.service

import com.github.fwh007.kotlintest.model.BaseResponse
import com.github.fwh007.kotlintest.model.New
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

/**
 * TODO 类说明
 *
 * @author : Winter
 */

interface NewService {

    @GET("list?ac=wap&format=json_raw&as=A17538D54D106FF&cp=585DF0A65F0F1E1")
    fun list(@Query("tag") tag: String, @Query("min_behot_time") startTime: Date)
            : Call<BaseResponse<List<New>>>

    @GET("i{id}/info/")
    fun detail(@Path("id") id: Long)
            : Call<BaseResponse<New>>

}