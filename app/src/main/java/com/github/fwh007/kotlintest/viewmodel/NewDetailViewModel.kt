package com.github.fwh007.kotlintest.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.github.fwh007.kotlintest.component.DaggerNewViewModelComponent
import com.github.fwh007.kotlintest.model.New
import com.github.fwh007.kotlintest.repository.NewRepository

/**
 * TODO 类说明
 *
 * @author : Winter
 */
class NewDetailViewModel() : ViewModel() {

    lateinit var aNew: LiveData<New>
    @javax.inject.Inject
    lateinit var newRepository: NewRepository

    init {
        DaggerNewViewModelComponent.builder().build().inject(this)
    }

    fun init(newId: Long) {
        this.aNew = newRepository.getNewDetail(newId)
    }
}
