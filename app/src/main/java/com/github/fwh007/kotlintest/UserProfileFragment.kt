package com.github.fwh007.kotlintest

import android.arch.lifecycle.LifecycleFragment
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import javax.inject.Inject

/**
 * TODO 类说明
 *
 * @author : Winter
 */

class UserProfileFragment : LifecycleFragment() {

    lateinit var idTV: TextView
    lateinit var nameTV: TextView
    lateinit var lastNameTV: TextView
    lateinit var toastBtn: Button

    val UID_KEY = "uid"
    @Inject
    lateinit var viewModel: UserProfileViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this)
                .get(UserProfileViewModel::class.java)
        viewModel.user?.observe(this, Observer<User> {
            user ->
            updateView(user)
        })
        val userId = arguments?.getString(UID_KEY)
        viewModel.init(userId)

        Thread {
            fun run() {
                val data: MutableLiveData<User> = MutableLiveData()
                data.value = User(34, "Feng", "Winter")
                viewModel.user = data
            }
        }.start()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_user_profile, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view ?: return
        idTV = view.findViewById(R.id.tv_id) as TextView
        nameTV = view.findViewById(R.id.tv_name) as TextView
        lastNameTV = view.findViewById(R.id.tv_last_name) as TextView
        toastBtn = view.findViewById(R.id.btn_toast) as Button

        toastBtn.setOnClickListener {
            Toast.makeText(activity, view.id.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    fun updateView(user: User?) {
        idTV.text = user?.id.toString()
        nameTV.text = user?.name ?: "NULL"
        lastNameTV.text = user?.lastName ?: "NULL"
    }
}