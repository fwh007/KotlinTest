package com.github.fwh007.kotlintest.repository

import com.github.fwh007.kotlintest.component.DaggerRepositoryComponent
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by Winter on 2017/6/26.
 */

abstract class Repository {
    @Inject
    lateinit protected var retrofit: Retrofit

    init {
        DaggerRepositoryComponent.builder().build().inject(this)
    }
}