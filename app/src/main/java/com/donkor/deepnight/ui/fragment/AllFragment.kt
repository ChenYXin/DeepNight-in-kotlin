package com.donkor.deepnight.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import com.donkor.deepnight.R

/**
 *
 * Created by Donkor on 2017/12/13.
 */
class AllFragment : CommonLazyLoadFragment() {

    override fun init(view: View?, savedInstanceState: Bundle?) {
        Log.e("asd","------------------all--1")
        super.init(view, savedInstanceState)
    }
    override fun lazyInit(view: View?, savedInstanceState: Bundle?) {
        Log.e("asd","------------------all--2")
    }

    override fun setEvent(view: View?) {
        Log.e("asd","------------------all--3")
    }

//    //    var isPrepared: Boolean = false
//    override fun initView() {
////        isPrepared = true
////        lazyLoad()
//    }
//
//    override fun loadData() {
//        Log.e("asd","---------------1")
//        Thread(Runnable {
//            val doc: Document = Jsoup.connect(ApiService.BASE_URL + ApiService.ALL_URL)
//                    .timeout(defaultTimeout).userAgent(defualtUserAgent1).get()
//            val imgSingle: Elements? = doc.getElementsByClass("img_single")
//            mList = ArrayList()
//            mSwipeRefresh.setColorSchemeColors(Color.rgb(47, 223, 189))
//
//
//            imgSingle?.map { it.select("img") }
//                    ?.forEach {
//                        mCommonBean = CommonBean(it.attr("title"), it.attr("src"))
//                        mList!!.add(mCommonBean!!)
//                    }
//
//
//            activity.runOnUiThread({
//                rv_common_list.layoutManager = LinearLayoutManager(context)
//                mCommomAdapter = CommonAdapter(context!!, mList!!)
//                rv_common_list.adapter = mCommomAdapter
//            })
//        }).start()
//    }

//    override fun setUserVisibleHint(isVisibleToUser: Boolean){
//        Log.e("asd","aalll-----------")
//    }

//    override fun onFragmentVisiableChange(b: Boolean) {
//        super.onFragmentVisiableChange(b)
//        if (b) loadData()
//    }
//    override fun lazyLoad() {
////        if (!isPrepared || !isVisible) {
////            return
////        }
//        Log.e("asd", "lazyLoad --- AllFragment")
//        //填充各控件的数据
//
//    }

    override fun getLayoutResources(): Int {
        return R.layout.fragment_common
    }

}