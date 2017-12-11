package com.donkor.deepnight.mvp.bean

/**
 * Created by donkor on 2017/12/11.
 */


class AllBean {
    //http://gank.io/api/data/福利/10/1
    val error: Boolean? = true //false
    val results: List<Result>? = null

    class Result {
        val _id: String? = "" //5a2dd04e421aa90fe2f02ccc
        val createdAt: String? = "" //2017-12-11T08:24:46.981Z
        val desc: String? = "" //12-11
        val publishedAt: String? = "" //2017-12-11T08:43:39.682Z
        val source: String? = "" //chrome
        val type: String? = "" //福利
        val url: String? = "" //http://7xi8d6.com1.z0.glb.clouddn.com/20171211082435_CCblJd_Screenshot.jpeg
        val used: Boolean? = false //true
        val who: String? = "" //daimajia
    }
}