package com.github.fwh007.kotlintest.component

import com.github.fwh007.kotlintest.module.NewRepositoryModule
import com.github.fwh007.kotlintest.viewmodel.NewDetailViewModel
import com.github.fwh007.kotlintest.viewmodel.NewListViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Winter on 2017/6/26.
 */

@Singleton
@Component(modules = arrayOf(NewRepositoryModule::class))
interface NewViewModelComponent {
    fun inject(viewModel: NewListViewModel)
    fun inject(viewModel: NewDetailViewModel)
}