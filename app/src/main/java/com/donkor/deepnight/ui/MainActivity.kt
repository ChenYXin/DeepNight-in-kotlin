package com.donkor.deepnight.ui

import android.app.Fragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.donkor.deepnight.R
import com.gyf.barlibrary.ImmersionBar

/**
 * 主页面
 */
private val TAG: String? = "MainActivity"

class MainActivity : AppCompatActivity() {


    val mTabs = arrayListOf<String>("aaa", "bbb", "ccc")
    lateinit var mFragments: ArrayList<Fragment>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ImmersionBar.with(this).transparentBar().barAlpha(0.3f).fitsSystemWindows(true).init()
        val window = window
        val params = window.attributes
        params.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        window.attributes = params

//        mFragments.add()
//        initRadioButton()
//        initToolBar()
        Thread(Runnable {
            val url = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1"

        }).start()

    }
}

//    private fun initRadioButton() {
//        rb_home.isChecked = true
//        rb_home.setTextColor(resources.getColor(R.color.black))
//        rb_home.setOnClickListener(this)
//        rb_find.setOnClickListener(this)
//        rb_hot.setOnClickListener(this)
//        rb_mine.setOnClickListener(this)
//
//    }
//
//    private fun initToolBar() {
//        tv_bar_title.text = "所有"
//        tv_bar_title.typeface = Typeface.createFromAsset(this.assets, "fonts/Lobster-1.4.otf")
//    }

//    private class MyHandler(activity: SplashActivity) : Handler() {
//        private val mActivity: WeakReference<SplashActivity> = WeakReference(activity)
//
//        override fun handleMessage(msg: Message) {
//            if (mActivity.get() == null) {
//                return
//            }
//            when (msg.what) {
//                SWITCH_MAINACTIVITY -> {
//                    Log.e(TAG, "SplashActivity --- switch_MainActivity")
//                }
//                else -> {
//                }
//            }
//        }
//    }

//    private fun clearState() {
//        rg_root.clearCheck()
//        rb_mine.setTextColor(ContextCompat.getColor(applicationContext,R.color.gray))
//        rb_hot.setTextColor(ContextCompat.getColor(applicationContext,R.color.gray))
//        rb_find.setTextColor(ContextCompat.getColor(applicationContext,R.color.gray))
//        rb_home.setTextColor(ContextCompat.getColor(applicationContext,R.color.gray))
//    }
//
//    override fun onClick(v: View?) {
//        clearState()
//        when (v?.id) {
//            R.id.rb_home -> {
//                rb_home.isChecked = true
//                rb_home.setTextColor(ContextCompat.getColor(applicationContext,R.color.black))
//            }
//            R.id.rb_find -> {
//                rb_find.isChecked = true
//                rb_find.setTextColor(ContextCompat.getColor(applicationContext,R.color.black))
//            }
//            R.id.rb_hot -> {
//                rb_hot.isChecked = true
//                rb_hot.setTextColor(ContextCompat.getColor(applicationContext,R.color.black))
//            }
//            R.id.rb_mine -> {
//                rb_mine.isChecked = true
//                rb_mine.setTextColor(ContextCompat.getColor(applicationContext,R.color.black))
//            }
//        }
//    }
//}