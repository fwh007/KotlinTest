package com.github.fwh007.kotlintest

import dagger.Module
import dagger.Provides

/**
 * TODO 类说明
 *
 * @author : Winter
 */

@Module
class NewRepositoryModule {
    @Provides
    fun provideTouTiaoNew(): NewRepository {
        return TouTiaoNewRepository()
    }
}