package com.donkor.deepnight.ui

import android.graphics.Typeface
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.donkor.deepnight.R
import com.donkor.deepnight.utils.switchActivity
import kotlinx.android.synthetic.main.activity_splash.*
import java.lang.ref.WeakReference

/**
 * 启动页
 */
private val SWITCH_MAINACTIVITY = 1000//跳转到主界面
private val TAG: String? = "SplashActivity"

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //设置全屏
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)
        initView()
        MyHandler(this).sendEmptyMessageDelayed(SWITCH_MAINACTIVITY, 1000)

    }

    private class MyHandler(activity: SplashActivity) : Handler() {
        private val mActivity: WeakReference<SplashActivity> = WeakReference(activity)

        override fun handleMessage(msg: Message) {
            if (mActivity.get() == null) {
                return
            }
            val activity = mActivity.get()
            when (msg.what) {
                SWITCH_MAINACTIVITY -> {
//                    Log.e(TAG, "SplashActivity --- switch_MainActivity")
                    activity!!.switchActivity<MainActivity>()
                    activity.finish()
                }
                else -> {
                }
            }
        }
    }

    private fun initView() {
        val font: Typeface = Typeface.createFromAsset(this.assets, "fonts/Lobster-1.4.otf")
        tv_splash_instruction.typeface = font
        tv_splash_instruction.text = getString(R.string.splash_activity_splash_instruction)
    }

    override fun onDestroy() {
        //  Remove all Runnable and Message.
        MyHandler(this).removeCallbacksAndMessages(null)
        super.onDestroy()
    }
}