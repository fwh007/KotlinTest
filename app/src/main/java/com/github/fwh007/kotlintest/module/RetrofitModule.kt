package com.github.fwh007.kotlintest.module

import com.github.fwh007.kotlintest.config.UrlConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Winter on 2017/6/26.
 */
@Module
class RetrofitModule {
    @Provides
    fun provideRetrofit(): Retrofit {
        //声明日志类
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        //设定日志级别
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        //自定义OkHttpClient
        val okHttpClient = OkHttpClient.Builder()
        //添加拦截器
        okHttpClient.addInterceptor(httpLoggingInterceptor);

        //创建并指定自定义的OkHttpClient
        return Retrofit.Builder()
                .baseUrl(UrlConfig.HOST_TOUTIAO)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build())
                .build()
    }

}