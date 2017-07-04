package com.github.fwh007.kotlintest.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.github.fwh007.kotlintest.R
import com.github.fwh007.kotlintest.model.New
import com.github.fwh007.kotlintest.util.ViewUtil
import com.github.fwh007.kotlintest.viewmodel.NewListViewModel
import kotlinx.android.synthetic.main.fragment_new_list.*
import kotlinx.android.synthetic.main.fragment_new_list_item.view.*
import org.jetbrains.anko.find
import java.util.*

/**
 * TODO 类说明
 *
 * @author : Winter
 */

class NewListFragment : BaseFragment() {

    companion object {
        fun build(): NewListFragment {
            return NewListFragment()
        }
    }

    val TAG_HOT = "news_hot"
    val TAG_DEFAULT = TAG_HOT

    lateinit var mViewModel: NewListViewModel
    val mNewList = ArrayList<New>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mViewModel = ViewModelProviders.of(this).get(NewListViewModel::class.java)
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, -1)
        mViewModel.init(TAG_DEFAULT, calendar.time)
        mViewModel.newList.observe(this, Observer<List<New>> {
            mNewList.clear()
            if (it != null) {
                mNewList.addAll(it)
            }
            recycler.adapter.notifyDataSetChanged()
        })
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_new_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.adapter = NewListAdapter(activity, mNewList)
    }

    inner class NewListAdapter(val context: Context, val newList: List<New>) : RecyclerView.Adapter<NewListViewHolder>() {

        override fun onCreateViewHolder(vg: ViewGroup?, type: Int): NewListViewHolder {
            return NewListViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_new_list_item, vg, false))
        }

        override fun onBindViewHolder(holder: NewListViewHolder?, position: Int) {
            val new = newList[position]
            holder?.titleTV?.text = new.title
            holder?.abstractTV?.text = new.abstract
            holder?.sourceTV?.text = new.source
            if (new.has_image) {
                holder?.imageIV?.visibility = View.VISIBLE
                val imageUrl: String? =
                        new.image_url ?: new.large_image_url ?: new.image_list?.get(0)?.get("url")
                //上面这一句等价于下面注释的几行代码
//            if (new.image_url != null) {
//                imageUrl = new.image_url
//            } else if (new.large_image_url != null) {
//                imageUrl = new.large_image_url
//            } else if (new.image_list != null && new.image_list.isNotEmpty()) {
//                imageUrl = new.image_list[0]["url"]
//            }
                ViewUtil.displayImage(context, imageUrl, holder?.imageIV)
            } else {
                holder?.itemView?.imageIV?.visibility = View.INVISIBLE
                ViewUtil.displayImage(context, null, holder?.imageIV)
            }
            holder?.itemView?.setOnClickListener {
                startFragment(NewDetailFragment.build(new.item_id))
            }
        }

        override fun getItemCount(): Int = newList.size
    }

    class NewListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTV = view.find<TextView>(R.id.titleTV)
        val abstractTV = view.find<TextView>(R.id.abstractTV)
        val sourceTV = view.find<TextView>(R.id.sourceTV)
        val imageIV = view.find<ImageView>(R.id.imageIV)
    }
}
