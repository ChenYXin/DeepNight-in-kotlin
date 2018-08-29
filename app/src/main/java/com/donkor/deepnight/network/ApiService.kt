package com.donkor.deepnight.network

/**
 * Created by donkor on 2017/12/11.
 */
interface ApiService {
    companion object {
        val BASE_URL: String
            get() = "https://www.dbmeinv.com/"
        val ALL_URL: String
            get() = "index.htm?pager_offset="
        val BOSOM: String
            get() = "index.htm?cid=2&pager_offset="
        val Buttocks: String
            get() = "index.htm?cid=6?pager_offset="
        val Stockings: String
            get() = "index.htm?cid=7&pager_offset="
        val Legs: String
            get() = "index.htm?cid=3&pager_offset="
        val Pretty: String
            get() = "index.htm?cid=4&pager_offset="
        val Hodgepodge: String
            get() = "index.htm?cid=5&pager_offset="
    }

}