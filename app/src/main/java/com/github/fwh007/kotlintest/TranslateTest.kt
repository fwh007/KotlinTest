package com.github.fwh007.kotlintest

import android.view.View

/**
 * Created by Winter on 2017/7/3.
 */

class TranslateTest {

    /**
     * 卡师傅就卡死

     * @param sdf 一个参数
     * *
     * @return 一个返回
     */
    fun start(sdf: String?): String {
        //嗯嗯空间看撒娇的反馈
        val a = 1
        View(KotlinApplication.instance).setOnClickListener {
            //因为巴拉巴拉所以咔擦咔擦
            val b = 2
        }

        val r = Round()
        r.radius = 344.89f
        r.radius
        r.radiusOfMeter

        return "kajsdflkajsf"
    }

    private inner class Round {
        internal var radius: Float = 0.toFloat()

        internal constructor() {

        }

        internal constructor(radius: Float) {
            this.radius = radius
        }

        internal val radiusOfMeter: Float
            get() = radius / 100
    }

    companion object {

        /**
         * 静态注释
         */
        private val isOK = true//尾巴注释
    }
}
