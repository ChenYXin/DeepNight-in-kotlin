package com.donkor.deepnight.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.donkor.deepnight.R
import com.donkor.deepnight.mvp.model.bean.CommonBean
import com.donkor.deepnight.utils.ImageLoadUtils

/**
 * Created by donkor on 2017/12/13.
 */
class CommonAdapter(context: Context, list: ArrayList<CommonBean>) : RecyclerView.Adapter<CommonAdapter.CommonHolder>() {
    var mContext: Context? = null
    private var mList: ArrayList<CommonBean>? = null
    private var mInflater: LayoutInflater? = null

    init {
        mContext=context
        mList=list
        mInflater= LayoutInflater.from(context)
    }
    override fun getItemCount(): Int {
        return mList?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CommonHolder {
        return CommonHolder(mInflater?.inflate(R.layout.item_common, parent, false))
    }

    override fun onBindViewHolder(holder: CommonHolder?, position: Int) {
        var title:String?= mList?.get(position)?.title

        holder?.tvTitle?.text=title
        ImageLoadUtils.display(mContext!!,holder?.ivPic, mList?.get(position)?.src!!)
    }

    class CommonHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var ivPic: ImageView = itemView?.findViewById<ImageView>(R.id.iv_pic) as ImageView
        var tvTitle: TextView = itemView?.findViewById<TextView>(R.id.tv_title) as TextView
    }
}