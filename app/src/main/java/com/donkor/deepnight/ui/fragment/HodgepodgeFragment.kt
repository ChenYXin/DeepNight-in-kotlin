package com.donkor.deepnight.ui.fragment

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import com.donkor.deepnight.R
import com.donkor.deepnight.adapter.CommonAdapter
import com.donkor.deepnight.mvp.model.bean.CommonBean
import com.donkor.deepnight.network.ApiService
import kotlinx.android.synthetic.main.fragment_common.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

/**
 * Created by donkor on 2017/12/14.
 */
class HodgepodgeFragment : BaseFragment() {

    override fun initView() {
        Thread(Runnable {
            val doc: Document = Jsoup.connect(ApiService.BASE_URL + ApiService.ALL_URL + ApiService.Hodgepodge)
                    .timeout(defaultTimeout).userAgent(defualtUserAgent4).get()
            val imgSingle: Elements? = doc.getElementsByClass("img_single")
            mList= ArrayList()
            mSwipeRefresh.setColorSchemeColors(Color.rgb(47, 223, 189))


            imgSingle?.map { it.select("img") }
                    ?.forEach {
                        mCommonBean= CommonBean(it.attr("title"), it.attr("src"))
                        mList!!.add(mCommonBean!!)
                    }


            activity.runOnUiThread({
                rv_common_list.layoutManager= LinearLayoutManager(context)
                mCommomAdapter= CommonAdapter(context!!, mList!!)
                rv_common_list.adapter=mCommomAdapter
            })
        }).start()
    }



    override fun getLayoutResources(): Int {
        return R.layout.fragment_common
    }

}