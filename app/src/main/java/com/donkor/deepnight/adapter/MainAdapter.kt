package com.donkor.deepnight.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.widget.DialogTitle

/**
 * Created by donkor on 2017/12/11.
 */
class MainAdapter(fm: FragmentManager, list: ArrayList<Fragment>, titles: List<String>) : FragmentPagerAdapter(fm) {
    var mFm: FragmentManager = fm
    var mList: ArrayList<Fragment> = list
    var mTitle: List<String> = titles
    override fun getItem(position: Int): Fragment {
        return mList[position]
    }

    override fun getCount(): Int {
        return mList.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mTitle[position]
    }
}