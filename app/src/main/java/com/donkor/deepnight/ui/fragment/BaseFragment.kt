package com.donkor.deepnight.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 *
 * Created by Donkor on 2017/12/13.
 */
abstract class BaseFragment : Fragment() {
    private var rootView: View? = null
    protected val defaultTimeout: Int = 1000
    protected val defualtUserAgent = "Opera/9.80 (Macintosh; Intel Mac OS X 10.6.8; U; fr) Presto/2.9.168 Version/11.52"
//    var doc: Document? = null
    //    val img_single = doc!!.getElementsByClass("img_single")
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

    abstract fun getLayoutResources(): Int
    abstract fun initView()
}
