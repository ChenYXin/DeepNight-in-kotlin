package com.donkor.deepnight.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import com.donkor.deepnight.R

/**
 *
 * Created by Donkor on 2017/12/13.
 */
class BosomFragment : CommonLazyLoadFragment() {

    override fun lazyInit(view: View?, savedInstanceState: Bundle?) {
        Log.e("asd","------------------bosom---1")
    }

    override fun init(view: View?, savedInstanceState: Bundle?) {
    }

    override fun setEvent(view: View?) {
    }
////    private var isPrepared: Boolean = false
//    override fun initView() {
////        isPrepared = true
////        lazyLoad()
//    }
//    override fun loadData() {
//        Log.e("asd","---------------2")
//        Thread(Runnable {
//            val doc: Document = Jsoup.connect(ApiService.BASE_URL + ApiService.ALL_URL+ApiService.BOSOM)
//                    .timeout(defaultTimeout).userAgent(defualtUserAgent1).get()
//            val imgSingle: Elements? = doc.getElementsByClass("img_single")
//            mList= ArrayList()
//            mSwipeRefresh.setColorSchemeColors(Color.rgb(47,223,189))
//
//
//            imgSingle?.map { it.select("img") }
//                    ?.forEach {
//                        mCommonBean= CommonBean(it.attr("title"),it.attr("src"))
//                        mList!!.add(mCommonBean!!)
//                    }
//
//
//            activity.runOnUiThread({
//                rv_common_list.layoutManager= LinearLayoutManager(context)
//                mCommomAdapter= CommonAdapter(context!!, mList!!)
//                rv_common_list.adapter=mCommomAdapter
//            })
//        }).start()
//    }
//    override fun onFragmentVisiableChange(b: Boolean) {
//        super.onFragmentVisiableChange(b)
//        if (b) loadData()
//    }
//    override fun lazyLoad() {
////        if (!isPrepared || !isVisible) {
////            return
////        }
//        Log.e("asd", "lazyLoad --- BosomFragment")
//        //填充各控件的数据
//        loadData()
//    }


    override fun getLayoutResources(): Int {
        return R.layout.fragment_common
    }


}