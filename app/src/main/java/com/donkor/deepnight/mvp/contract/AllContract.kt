package com.donkor.deepnight.mvp.contract

import android.support.v4.content.res.FontResourcesParserCompat
import com.donkor.deepnight.base.BasePersenter
import com.donkor.deepnight.base.BaseView
import com.donkor.deepnight.mvp.bean.AllBean

/**
 * Created by donkor on 2017/12/11.
 */
interface AllContract{
    interface View:BaseView<Persenter>{
        fun setData(bean: AllBean)
    }
    interface Persenter:BasePersenter{
        fun requestData(strategy: String)
    }
}