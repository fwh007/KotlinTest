package com.github.fwh007.kotlintest.view

import android.arch.lifecycle.LifecycleFragment
import com.github.fwh007.kotlintest.MainActivity

/**
 * Created by Winter on 2017/6/27.
 */
abstract class BaseFragment:LifecycleFragment() {

    fun startFragment(anotherFragment: BaseFragment) {
        if (activity is MainActivity) {
            (activity as MainActivity).startFragment(anotherFragment)
        }

        val a = 23 to 45
    }
}