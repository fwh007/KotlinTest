package com.github.fwh007.kotlintest.module

import com.github.fwh007.kotlintest.repository.NewRepository
import com.github.fwh007.kotlintest.repository.TouTiaoNewRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * TODO 类说明
 *
 * @author : Winter
 */

@Module
class NewRepositoryModule {
    @Singleton
    @Provides
    fun provideTouTiaoNew(): NewRepository = TouTiaoNewRepository()
}