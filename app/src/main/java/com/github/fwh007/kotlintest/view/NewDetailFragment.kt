package com.github.fwh007.kotlintest.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.TextView
import com.github.fwh007.kotlintest.R
import com.github.fwh007.kotlintest.model.New
import com.github.fwh007.kotlintest.viewmodel.NewDetailViewModel
import kotterknife.bindView


/**
 * Created by Winter on 2017/6/27.
 */
class NewDetailFragment : BaseFragment() {
    companion object {
        fun build(id: Long): NewDetailFragment {
            val fragment: NewDetailFragment = NewDetailFragment()
            val bundle = fragment.arguments ?: Bundle()
            bundle.putLong("id", id)
            fragment.arguments = bundle
            return fragment
        }
    }

    val titleTV: TextView by bindView(R.id.titleTV)
    val sourceTV: TextView by bindView(R.id.sourceTV)
    val webView: WebView by bindView(R.id.webView)

    lateinit var mViewModel: NewDetailViewModel
    lateinit var mNew: New

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mViewModel = ViewModelProviders.of(this).get(NewDetailViewModel::class.java)
        mViewModel.init(arguments.getLong("id"))
        mViewModel.aNew.observe(this, Observer {
            if (it != null) {
                mNew = it
                updateView()
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_new_detail, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        val settings = webView.settings
        settings.useWideViewPort = true
        settings.loadWithOverviewMode = true
        settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN
    }

    fun updateView() {
        titleTV.text = mNew.title
        sourceTV.text = mNew.source
//        webView.loadData(mNew.content, "text/html", "UTF-8")
        webView.loadDataWithBaseURL(null, mNew.content, "text/html", "utf-8", null)
    }
}