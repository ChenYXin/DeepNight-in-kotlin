package com.donkor.deepnight.adapter

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.donkor.deepnight.R
import com.donkor.deepnight.mvp.model.bean.CommonBean
import com.donkor.deepnight.ui.DragPhotoActivity
import com.donkor.deepnight.utils.ImageLoadUtils


/**
 * Created by donkor on 2017/12/13.
 */
class CommonAdapter(context: Activity?, list: ArrayList<CommonBean>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var mContext: Activity? = null
    private var mList: ArrayList<CommonBean>? = null
    private var mInflater: LayoutInflater? = null
    private val TYPE_ITEM: Int? = 0
    private val TYPE_FOOTER: Int? = 1

    //上拉加载更多
    val PULLUP_LOAD_MORE: Int? = 0
    //正在加载中
    val LOAD_MORE: Int? = 1
    //没有加载更多 隐藏
    val NO_LOAD_MORE: Int? = 2

    //上拉加载更多状态-默认为0
    private var mLoadMoreStatus: Int? = 0

    init {
        mContext = context
        mList = list
        mInflater = LayoutInflater.from(context)
    }

    override fun getItemCount(): Int {
        return mList?.size ?: 0
    }

    override fun getItemViewType(position: Int): Int {
        return if (position + 1 == itemCount) {
            TYPE_FOOTER!!
        } else {
            TYPE_ITEM!!
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
        when (viewType) {
            TYPE_ITEM -> return CommonHolder(mInflater?.inflate(R.layout.item_common, parent, false))
            TYPE_FOOTER -> return FooterViewHolder(mInflater?.inflate(R.layout.load_more, parent, false))
        }
        return null
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val title: String? = mList?.get(position)?.title
        if (holder is CommonHolder) {
            holder.tvTitle.text = title
            ImageLoadUtils.display(mContext, holder.ivPic, mList?.get(position)?.src)
            holder.ivPic.setOnClickListener({
                startPhotoActivity(mContext, holder.ivPic, mList?.get(position)?.src)
            })
        } else if (holder is FooterViewHolder) {
            when (mLoadMoreStatus) {
                PULLUP_LOAD_MORE -> holder.tvLoadText?.text = "上拉加载更多"
                LOAD_MORE -> holder.tvLoadText?.text = "正在加载更多..."
                NO_LOAD_MORE -> holder.linLoadLayout?.visibility = View.GONE
            }
        }
    }

    class CommonHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var ivPic: ImageView = itemView?.findViewById<ImageView>(R.id.iv_pic) as ImageView
        var tvTitle: TextView = itemView?.findViewById<TextView>(R.id.tv_title) as TextView
    }

    class FooterViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var pbLoad: ProgressBar? = null
        var tvLoadText: TextView? = null
        var linLoadLayout: LinearLayout? = null

        init {
            pbLoad = itemView?.findViewById(R.id.pb_load)
            tvLoadText = itemView?.findViewById(R.id.tv_load_text)
            linLoadLayout = itemView?.findViewById(R.id.lin_load_layout)
        }
    }

    fun changeMoreStatus(status: Int) {
        mLoadMoreStatus = status
        notifyDataSetChanged()
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