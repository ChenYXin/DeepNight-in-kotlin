package com.donkor.deepnight.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View

/**
 *
 * Created by Donkor on 2017/12/14.
 */
abstract class CommonLazyLoadFragment : BaseFragment() {
    /**
     * 标记已加载完成，只能加载一次
     */
    private var hasLoaded = false
    /**
     * 标记是否已经onCreate
     */
    private var isCreated = false
    /**
     * 界面对于用户是否可见
     */
    private var mIsVisibleToUser = false
    private var rootView: View? = null
    override fun init(view: View?, savedInstanceState: Bundle?) {
        isCreated = true
        this.rootView = view
        Log.e("asd","init ------------1")
        lazyLoad(rootView, savedInstanceState)
    }
//    override fun init(view: View, savedInstanceState: Bundle) {
//        isCreated = true
//        this.rootView = view
//        lazyLoad(rootView!!, savedInstanceState)
//    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        Log.e("asd","onHiddenChanged ------------hidden "+hidden)
        this.mIsVisibleToUser = hidden
        lazyLoad(rootView, null)
    }
    /**
     * 监听界面是否展示给用户，实现懒加载
     */
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        Log.e("asd","setUserVisibleHint ------------isVisibleToUser "+isVisibleToUser)
        this.mIsVisibleToUser = isVisibleToUser
        lazyLoad(rootView, null)
    }


    /**
     * 懒加载方法，获取数据什么的放到这边来使用，在切换到这个界面时才进行网络请求
     */
    private fun lazyLoad(view: View?, savedInstanceState: Bundle?) {
        //如果该界面不对用户显示、已经加载、fragment还没有创建，
        //三种情况任意一种，不获取数据
        Log.e("asd","!isVisibleToUser:"+!mIsVisibleToUser)
        Log.e("asd","hasLoaded:"+hasLoaded)
        Log.e("asd","!isCreated:"+!isCreated)
        if (!mIsVisibleToUser || hasLoaded || !isCreated) {
            return
        }
        lazyInit(view, savedInstanceState)
        hasLoaded = true
    }

    /**
     * 懒加载的初始化方法
     */
    abstract fun lazyInit(view: View?, savedInstanceState: Bundle?)

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("asd","destroyview")
        isCreated = false
        hasLoaded = false
    }
}