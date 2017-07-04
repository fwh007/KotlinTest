package com.github.fwh007.kotlintest.repository

import com.github.fwh007.kotlintest.model.New

/**
 * TODO 类说明
 *
 * @author : Winter
 */

abstract class NewRepository:Repository() {

    abstract fun getNewDetail(id: Long): android.arch.lifecycle.LiveData<New>

    abstract fun getNewList(tag: String, startTime: java.util.Date): android.arch.lifecycle.LiveData<List<New>>
}