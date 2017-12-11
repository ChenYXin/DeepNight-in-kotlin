package com.donkor.deepnight.network

/**
 * Created by donkor on 2017/12/11.
 */
interface ApiService{
    companion object {
        val BASE_URL:String
            //https://www.dbmeinv.com/dbgroup/show.htm
        get() = "https://www.dbmeinv.com/dbgroup/"
    }
}