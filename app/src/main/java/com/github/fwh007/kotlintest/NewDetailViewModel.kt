package com.github.fwh007.kotlintest

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel

/**
 * TODO 类说明
 *
 * @author : Winter
 */
class NewDetailViewModel() : ViewModel() {

    lateinit var aNew: LiveData<New>
    lateinit var newRepository: NewRepository

    constructor(newRepository: NewRepository) : this() {
        this.newRepository = newRepository
    }

    fun init(newId: Long) {
        aNew ?: return
        this.aNew = newRepository.getNewDetail(newId)
    }
}
