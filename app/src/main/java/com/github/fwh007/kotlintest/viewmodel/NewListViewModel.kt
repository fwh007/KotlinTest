package com.github.fwh007.kotlintest.viewmodel

import com.github.fwh007.kotlintest.component.DaggerNewViewModelComponent
import com.github.fwh007.kotlintest.model.New
import com.github.fwh007.kotlintest.repository.NewRepository

/**
 * TODO 类说明
 *
 * @author : Winter
 */
class NewListViewModel : android.arch.lifecycle.ViewModel() {

    lateinit var newList: android.arch.lifecycle.LiveData<List<New>>
    @javax.inject.Inject
    lateinit var newRepository: NewRepository

    init {
        DaggerNewViewModelComponent.builder().build().inject(this)
    }

    fun init(tag: String, startTime: java.util.Date) {
        newList = newRepository.getNewList(tag, startTime)
    }
}
