package com.donkor.deepnight.ui.fragment

import android.util.Log
import com.donkor.deepnight.R
import com.donkor.deepnight.network.ApiService
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

/**
 *
 * Created by Donkor on 2017/12/13.
 */
class AllFragment : BaseFragment() {

    override fun initView() {
        Thread(Runnable {
            val doc: Document = Jsoup.connect(ApiService.BASE_URL + ApiService.ALL_URL).timeout(defaultTimeout).userAgent(defualtUserAgent).get()
            val imgSingle: Elements? = doc.getElementsByClass("img_single")
            imgSingle?.map { it.select("img").attr("title") }?.forEach { Log.e("asd", "title : " + it) }
        }).start()
    }

    override fun getLayoutResources(): Int {
        return R.layout.fragment_all
    }

}