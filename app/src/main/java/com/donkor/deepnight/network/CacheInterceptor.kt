package com.donkor.deepnight.network

import android.content.Context
import android.util.Log
import com.donkor.deepnight.utils.NetworkUtils
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response

/**
 *
 * Created by Donkor on 2017/12/13.
 */
class CacheInterceptor(context: Context) : Interceptor {
    private val TAG: String = "CacheInterceptor"
    private val mContext = context
    override fun intercept(chain: Interceptor.Chain?): Response? {
        var request = chain?.request()
        return if (NetworkUtils.isNetConnected(mContext)) {
            val response = chain?.proceed(request)
            //read from cache for 60 s
            val maxAge = 60
            val cacheControl = request?.cacheControl().toString()
            Log.e(TAG, "6s load cache " + cacheControl)
            response?.newBuilder()?.removeHeader("Pragma")?.removeHeader("Cache-Control")?.header("Cache-Control", "public, max-age=" + maxAge)?.build()
        } else {
            Log.e(TAG, " no network load cache")
            request = request?.newBuilder()?.cacheControl(CacheControl.FORCE_CACHE)?.build()
            val response = chain?.proceed(request)
            //set cache times is 3 days
            val maxStale = 60 * 60 * 24 * 3
            response?.newBuilder()?.removeHeader("Pragma")?.removeHeader("Cache-Control")?.header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)?.build()
        }
    }
}