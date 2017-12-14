package com.donkor.deepnight.ui

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.donkor.deepnight.R
import kotlinx.android.synthetic.main.activity_about.*


/**
 * Created by donkor on 2017/12/14.
 */
class AboutActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        tvVersion.text=getAppVersionName(this)
    }

    /**
     * 返回当前程序版本名
     */
    fun getAppVersionName(context: Context): String {
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