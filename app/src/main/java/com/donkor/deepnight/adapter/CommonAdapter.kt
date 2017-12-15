package com.donkor.deepnight.adapter

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.donkor.deepnight.R
import com.donkor.deepnight.mvp.model.bean.CommonBean
import com.donkor.deepnight.ui.DragPhotoActivity
import com.donkor.deepnight.utils.ImageLoadUtils


/**
 * Created by donkor on 2017/12/13.
 */
class CommonAdapter(context: Activity?, list: ArrayList<CommonBean>?) : RecyclerView.Adapter<CommonAdapter.CommonHolder>() {
    var mContext: Activity? = null
    private var mList: ArrayList<CommonBean>? = null
    private var mInflater: LayoutInflater? = null

    init {
        mContext = context
        mList = list
        mInflater = LayoutInflater.from(context)
    }

    override fun getItemCount(): Int {
        return mList?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CommonHolder {
        return CommonHolder(mInflater?.inflate(R.layout.item_common, parent, false))
    }

    override fun onBindViewHolder(holder: CommonHolder?, position: Int) {
        val title: String? = mList?.get(position)?.title

        holder?.tvTitle?.text = title
        ImageLoadUtils.display(mContext, holder?.ivPic, mList?.get(position)?.src)
        holder?.ivPic?.setOnClickListener({
            startPhotoActivity(mContext, holder.ivPic, mList?.get(position)?.src)
        })
    }

    class CommonHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var ivPic: ImageView = itemView?.findViewById<ImageView>(R.id.iv_pic) as ImageView
        var tvTitle: TextView = itemView?.findViewById<TextView>(R.id.tv_title) as TextView
    }

    private fun startPhotoActivity(context: Activity?, imageView: ImageView?, picUrl: String?) {

        val intent = Intent(context, DragPhotoActivity::class.java)

        intent.putExtra("picUrl", picUrl)
        intent.putExtra("height", imageView?.height)
        intent.putExtra("width", imageView?.width)
        context?.startActivity(intent)
        context?.overridePendingTransition(0, 0)
    }
}