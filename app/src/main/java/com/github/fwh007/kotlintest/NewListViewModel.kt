package com.github.fwh007.kotlintest

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import java.util.*
import javax.inject.Inject

/**
 * TODO 类说明
 *
 * @author : Winter
 */
class NewListViewModel() : ViewModel() {

    lateinit var newList: LiveData<List<New>>
    lateinit var newRepository: NewRepository

    @Inject
    constructor(newRepository: NewRepository) : this() {
        this.newRepository = newRepository
    }

    fun init(tag: String, startTime: Date) {
        if (newList != null) return
        newList = newRepository.getNewList(tag, startTime)
    }
}
