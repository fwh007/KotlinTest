package com.github.fwh007.kotlintest.util

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.github.fwh007.kotlintest.KotlinApplication
import com.github.fwh007.kotlintest.table.NewTable
import org.jetbrains.anko.db.*
import kotlin.properties.Delegates

/**
 * Created by Winter on 2017/6/30.
 */

class SQLiteHelper(context: Context = KotlinApplication.instance)
    : ManagedSQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        val DATABASE_NAME = "new"
        val DATABASE_VERSION = 1
        var instance: SQLiteHelper by Delegates.notNull()
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(NewTable.TABLE_NAME, true,
                NewTable.ID to INTEGER + PRIMARY_KEY,
                NewTable.SOURCE to TEXT,
                NewTable.CONTEXT to TEXT)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(NewTable.TABLE_NAME, true)
        onCreate(db)
    }
}