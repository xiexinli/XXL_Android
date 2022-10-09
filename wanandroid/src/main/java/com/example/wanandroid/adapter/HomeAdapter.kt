package com.example.wanandroid.adapter

import android.content.Context
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.wanandroid.R
import com.example.wanandroid.bean.Datas

class HomeAdapter(context: Context, datas: MutableList<Datas>) :
    BaseQuickAdapter<Datas, BaseViewHolder>(R.layout.home_list_item, datas) {
    init {
        addChildClickViewIds(R.id.homeItemType,R.id.homeItemLike)
    }
    override fun convert(holder: BaseViewHolder, item: Datas) {
        @Suppress("DEPRECATION")
        holder.setText(R.id.homeItemTitle, item.title)
            .setText(R.id.homeItemAuthor, item.author)
            .setText(R.id.homeItemType, item.chapterName)
//            .addOnClickListener(R.id.homeItemType)
            .setTextColor(R.id.homeItemType, context.resources.getColor(R.color.colorPrimary))
//            .linkify(R.id.homeItemType)
            .setText(R.id.homeItemDate, item.niceDate)
            .setImageResource(
                R.id.homeItemLike,
                if (item.collect) R.drawable.ic_action_like else R.drawable.ic_action_no_like
            )
//            .addOnClickListener(R.id.homeItemLike)
    }
}