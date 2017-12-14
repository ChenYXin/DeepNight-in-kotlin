package com.donkor.deepnight.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.donkor.deepnight.adapter.CommonAdapter
import com.donkor.deepnight.mvp.model.bean.CommonBean

/**
 *
 * Created by Donkor on 2017/12/13.
 */
abstract class BaseFragment : Fragment() {
    protected val defaultTimeout: Int = 3000
    protected val defualtUserAgent = "Opera/9.80 (Macintosh; Intel Mac OS X 10.6.8; U; fr) Presto/2.9.168 Version/11.52"
    protected var mCommomAdapter: CommonAdapter? = null
    protected var mCommonBean: CommonBean? = null

    var rootView: View? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (rootView == null) {
            rootView = inflater?.inflate(getLayoutResources(), container, false)
        }
        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden)
            loadData()

    }


    abstract fun getLayoutResources(): Int
    abstract fun initView()
    abstract fun loadData()
}
