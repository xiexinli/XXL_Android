package com.example.wanandroid.adapter

import android.content.Context
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.wanandroid.R
import com.example.wanandroid.bean.FriendListResponse

class CommonAdapter(context: Context, datas: MutableList<FriendListResponse.Data>) :
    BaseQuickAdapter<FriendListResponse.Data, BaseViewHolder>(R.layout.common_list_item, datas) {

    override fun convert(holder: BaseViewHolder, item: FriendListResponse.Data) {
        item ?: return
        holder.setText(R.id.commonItemTitle, item.name.trim())
    }
}