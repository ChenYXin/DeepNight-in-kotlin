package com.donkor.deepnight.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 *网络工具
 * Created by Donkor on 2017/12/13.
 */
object NetworkUtils {
    fun isNetConnected(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
        return if (networkInfo == null) {
            false
        } else {
            networkInfo.isAvailable && networkInfo.isConnected
        }
    }
}