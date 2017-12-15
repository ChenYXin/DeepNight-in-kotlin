package com.donkor.deepnight.ui

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.donkor.deepnight.R
import com.gyf.barlibrary.ImmersionBar
import kotlinx.android.synthetic.main.activity_about.*


/**
 * Created by donkor on 2017/12/14.
 */
class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ImmersionBar.with(this).transparentBar().barAlpha(0.6f).fitsSystemWindows(true).init()
        val window = window
        val params = window.attributes
        params.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        window.attributes = params
        setContentView(R.layout.activity_about)

        tvVersion.text = getAppVersionName(this)
        btnBack.setOnClickListener({
            finish()
        })
//        Glide.with(this)
//                .load("https://ww3.sinaimg.cn/bmiddle/0060lm7Tgy1fmh86a08lnj30hs0np0ul.jpg")
//                .into(ivLogo)
    }

//    fun onClick(view: View) {
//        startPhotoActivity(this, view as ImageView)
//    }


//    private fun startPhotoActivity(context: Context, imageView: ImageView) {
//        val intent = Intent(context, DragPhotoActivity::class.java)
//        val location = IntArray(2)
//
//        imageView.getLocationOnScreen(location)
//        intent.putExtra("picUrl", "https://ww3.sinaimg.cn/bmiddle/0060lm7Tgy1fmh86a08lnj30hs0np0ul.jpg")
//        intent.putExtra("left", location[0])
//        intent.putExtra("top", location[1])
//        intent.putExtra("height", imageView.height)
//        intent.putExtra("width", imageView.width)
//
//        context.startActivity(intent)
//        overridePendingTransition(0, 0)
//    }
    /**
     * 返回当前程序版本名
     */
    private fun getAppVersionName(context: Context): String {
        var versionName: String? = ""
        try {
            val pm = context.packageManager
            val pi = pm.getPackageInfo(context.packageName, 0)
            versionName = pi.versionName
            if (versionName == null || versionName.isEmpty()) {
                return ""
            }
        } catch (e: Exception) {
            Log.e("VersionInfo", "Exception", e)
        }

        return versionName.toString()
    }
}