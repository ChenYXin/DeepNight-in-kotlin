package com.donkor.deepnight.network

import retrofit2.http.GET

/**
 * Created by donkor on 2017/12/11.
 */
interface ApiService {
    companion object {
        val BASE_URL: String
            get() = "https://www.dbmeinv.com/dbgroup/"
        val ALL_URL: String
            get() = "show.htm"
        val BOSOM: String
            get() = "?cid=2"
        val Buttocks: String
            get() = "?cid=6"
        val Stockings: String
            get() = "?cid=7"
        val Legs: String
            get() = "?cid=3"
        val Pretty: String
            get() = "?cid=4"
        val Hodgepodge: String
            get() = "?cid=5"
    }

    @GET("show.htm")
    fun getAllData(): String

}