package com.donkor.deepnight.network

import retrofit2.http.GET

/**
 * Created by donkor on 2017/12/11.
 */
interface ApiService{
    companion object {
        val BASE_URL:String
        get() = "https://www.dbmeinv.com/dbgroup/"
        val ALL_URL:String
        get() = "show.htm"
        val BOSOM_URL:String
        get() = "?cid=2"
    }

    @GET("show.htm")
    fun getAllData():String

}