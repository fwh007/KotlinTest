package com.github.fwh007.kotlintest

import android.arch.lifecycle.LifecycleFragment
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

/**
 * TODO 类说明
 *
 * @author : Winter
 */

class NewListFragment : LifecycleFragment() {

    lateinit var countTV: TextView

    private val UID_KEY = "uid"
    lateinit var viewModel: NewListViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val userId = arguments.getString(UID_KEY)
        viewModel = ViewModelProviders.of(this).get(NewListViewModel::class.java)
        viewModel.init(userId)
        viewModel.newList.observe(this, Observer<List<New>> {
            countTV.text = it?.size.toString()
        })
        viewModel.newList.observe(this, object : Observer<List<New>> {
            override fun onChanged(p0: List<New>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_new_profile, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        countTV = view?.findViewById(R.id.tv_count) as TextView
        countTV.setOnClickListener {
            it?.tag = "kajdksj"
        }
        this.toast()
    }

    fun Fragment.toast() {
        Toast.makeText(activity, "kasjdfk", Toast.LENGTH_SHORT).show()
    }
}