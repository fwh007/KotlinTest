package com.github.fwh007.kotlintest.component

import com.github.fwh007.kotlintest.module.RetrofitModule
import com.github.fwh007.kotlintest.repository.Repository
import dagger.Component

/**
 * Created by Winter on 2017/6/26.
 */

@Component(modules = arrayOf(RetrofitModule::class))
interface RepositoryComponent {
    fun inject(repository: Repository)
}