package com.github.fwh007.kotlintest.database

import com.github.fwh007.kotlintest.table.NewTable
import com.github.fwh007.kotlintest.util.SQLiteHelper
import org.jetbrains.anko.db.select

/**
 * Created by Winter on 2017/7/3.
 */

class NewDBHelper {

    val helper = SQLiteHelper.instance

    fun selectNewById(id:Long) = helper.use {
        val request = "${NewTable.ID} = {id} "

        val dailyForecast = select(NewTable.TABLE_NAME)
                .whereArgs(request, "id" to id)
//                .parseList { DayForecast(HashMap(it)) }
        // New Detail 接口没办法返回ID，这个比较尴尬
    }
}