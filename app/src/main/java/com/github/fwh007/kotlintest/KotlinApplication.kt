package com.github.fwh007.kotlintest

import android.app.Application
import kotlin.properties.Delegates

/**
 * Created by Winter on 2017/6/30.
 */

class KotlinApplication : Application() {
    companion object {

        var instance: KotlinApplication  by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
