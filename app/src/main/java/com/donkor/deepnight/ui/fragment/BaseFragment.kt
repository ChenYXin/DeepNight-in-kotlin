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
    private var rootView: View? = null
    protected val defaultTimeout: Int = 3000
    protected val defualtUserAgent1 = "Opera/9.80 (Macintosh; Intel Mac OS X 10.6.8; U; fr) Presto/2.9.168 Version/11.52"
    protected val defualtUserAgent2 = "Mozilla/5.0 (Windows NT 5.2) AppleWebKit/534.30 (KHTML, like Gecko) Chrome/12.0.742.122 Safari/534.30"
    protected val defualtUserAgent3 = "Mozilla/5.0 (Windows NT 5.2) AppleWebKit/534.30 (KHTML, like Gecko) Chrome/12.0.742.122 Safari/534.30"
    protected val defualtUserAgent4 = "Mozilla/5.0 (Windows NT 5.1; rv:5.0) Gecko/20100101 Firefox/5.0"
    protected val defualtUserAgent5 = "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN) AppleWebKit/533.21.1 (KHTML, like Gecko) Version/5.0.5 Safari/533.21.1"
    protected val defualtUserAgent6 = "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.2; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET4.0E; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729; .NET4.0C)"
    protected val defualtUserAgent7 = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 2.0.50727) "
    protected var mCommomAdapter: CommonAdapter? = null
    protected var mList: ArrayList<CommonBean>? = null
    protected var mCommonBean: CommonBean? = null

    //    var doc: Document? = null
    //    val img_single = doc!!.getElementsByClass("img_single")
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        if (rootView == null) {
            rootView = inflater?.inflate(getLayoutResources(), container, false)
        }
        initView()
        return rootView
    }

//    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//    }

    abstract fun getLayoutResources(): Int
    abstract fun initView()
}
