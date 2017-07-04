package com.github.fwh007.kotlintest.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by Winter on 2017/6/26.
 */

class ViewUtil {
    companion object {
        fun displayImage(context: Context, imageUrl: String?, view: ImageView?) {
            Glide.with(context).load(imageUrl).into(view)
        }
    }
}