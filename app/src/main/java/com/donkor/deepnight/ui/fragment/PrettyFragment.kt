package com.donkor.deepnight.ui.fragment

import android.os.Bundle
import android.view.View
import com.donkor.deepnight.R

/**
 * Created by donkor on 2017/12/14.
 */
class PrettyFragment : CommonLazyLoadFragment() {
    override fun lazyInit(view: View?, savedInstanceState: Bundle?) {
    }

    override fun setEvent(view: View?) {
    }

    override fun init(view: View?, savedInstanceState: Bundle?) {
    }
//    override fun loadData() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//
//    override fun initView() {
//        Thread(Runnable {
//            val doc: Document = Jsoup.connect(ApiService.BASE_URL + ApiService.ALL_URL + ApiService.Pretty)
//                    .timeout(defaultTimeout).userAgent(defualtUserAgent6).get()
//            val imgSingle: Elements? = doc.getElementsByClass("img_single")
//            mList= ArrayList()
//            mSwipeRefresh.setColorSchemeColors(Color.rgb(47, 223, 189))
//
//
//            imgSingle?.map { it.select("img") }
//                    ?.forEach {
//                        mCommonBean= CommonBean(it.attr("title"), it.attr("src"))
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



    override fun getLayoutResources(): Int {
        return R.layout.fragment_common
    }

}