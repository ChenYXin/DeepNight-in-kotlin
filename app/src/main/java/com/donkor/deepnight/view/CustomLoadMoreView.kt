package com.donkor.deepnight.view

import com.chad.library.adapter.base.loadmore.LoadMoreView
import com.donkor.deepnight.R

/**
 * Created by donkor on 2017/12/13.
 */
class CustomLoadMoreView : LoadMoreView() {
    override fun getLayoutId(): Int {
        return R.layout.view_load_more
    }

    override fun getLoadingViewId(): Int {
        return R.id.load_more_loading_view
    }

    override fun getLoadEndViewId(): Int {
        return R.id.load_more_load_fail_view
    }

    override fun getLoadFailViewId(): Int {
        return R.id.load_more_load_end_view
    }
}