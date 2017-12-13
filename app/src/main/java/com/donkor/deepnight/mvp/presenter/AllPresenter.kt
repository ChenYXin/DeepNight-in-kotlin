package com.donkor.deepnight.mvp.presenter

import android.content.Context
import com.donkor.deepnight.mvp.contract.AllContract

/**
 *
 * Created by Donkor on 2017/12/13.
 */
class AllPresenter(context: Context, view: AllContract.View) : AllContract.Persenter {
    private var mContext: Context? = null
    private var mView: AllContract.View? = null

    init {
        mContext = context
        mView = view
    }

    override fun start() {
        requestData()
    }

    override fun requestData() {

    }
}