package com.donkor.deepnight.ui.fragment

import android.graphics.Color
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.donkor.deepnight.R
import com.donkor.deepnight.adapter.CommonAdapter
import com.donkor.deepnight.mvp.model.bean.CommonBean
import com.donkor.deepnight.network.ApiService
import kotlinx.android.synthetic.main.fragment_common.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

/**
 *大胸妹
 * Created by Donkor on 2017/12/13.
 */
class BosomFragment : BaseFragment(), SwipeRefreshLayout.OnRefreshListener {
    private var mList: ArrayList<CommonBean>? = null
    override fun onRefresh() {
        mSwipeRefresh.isRefreshing = false
        bosomData(mPage)
    }

    private var mPage: Int? = 1
    override fun loadData() {
        if (mList!!.isEmpty() )
            bosomData(mPage)
    }

    override fun initView() {
        mSwipeRefresh.setColorSchemeColors(Color.rgb(47, 223, 189))
        mSwipeRefresh.setOnRefreshListener(this)
        mRvCommonList.layoutManager = GridLayoutManager(context, 2)
        mList = ArrayList()
        mRvCommonList.setOnScrollListener(object : RecyclerView.OnScrollListener() {
            var lastVisibleItem:Int?=0
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem!! + 1 == mCommomAdapter?.itemCount) {
                    mPage= mPage!! +1
                    bosomData(mPage)
                }
            }

            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView?.layoutManager as LinearLayoutManager
                //最后一个可见的ITEM
                lastVisibleItem = layoutManager.findLastVisibleItemPosition()
            }
        })
    }

    private fun bosomData(page:Int?) {
        Thread(Runnable {
            Log.e("asd","url : "+ApiService.BASE_URL +  ApiService.BOSOM+page)
            val doc: Document = Jsoup.connect(ApiService.BASE_URL +  ApiService.BOSOM+page)
                    .timeout(defaultTimeout).userAgent(defualtUserAgent).get()
            val imgSingle: Elements? = doc.getElementsByClass("img_single")

            imgSingle?.map { it.select("img") }
                    ?.forEach {
                        mCommonBean = CommonBean(it.attr("title"), it.attr("src"))
                        mList!!.add(mCommonBean!!)
                    }


            activity.runOnUiThread({
                if(mPage!=1){
                    mRvCommonList.adapter.notifyDataSetChanged()
                }else{
                    mCommomAdapter = CommonAdapter(context!!, mList!!)
                    mRvCommonList.adapter = mCommomAdapter
                }
            })
        }).start()
    }


    override fun getLayoutResources(): Int {
        return R.layout.fragment_common
    }


}