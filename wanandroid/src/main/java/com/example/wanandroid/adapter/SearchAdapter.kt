package com.example.wanandroid.adapter

import android.content.Context
import android.text.Html
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.wanandroid.R
import com.example.wanandroid.bean.Datas

class SearchAdapter(context: Context, datas: MutableList<Datas>) :
    BaseQuickAdapter<Datas, BaseViewHolder>(R.layout.home_list_item, datas) {
    init {
        addChildClickViewIds(R.id.homeItemType, R.id.homeItemLike)
    }

    override fun convert(helper: BaseViewHolder, item: Datas) {
        item ?: return
        @Suppress("DEPRECATION")
        helper.setText(R.id.homeItemTitle, Html.fromHtml(item.title))
            .setText(R.id.homeItemAuthor, item.author)
            .setText(R.id.homeItemType, item.chapterName)
            .setText(
                R.id.homeItemDate,
                if (item.originId != 0) context.getString(
                    R.string.bookmark_time,
                    item.niceDate
                ) else item.niceDate
            )
//            .addOnClickListener(R.id.homeItemType)
            .setTextColor(R.id.homeItemType, context.resources.getColor(R.color.colorPrimary))
//            .linkify(R.id.homeItemType)
            .setImageResource(
                R.id.homeItemLike,
                if (item.originId != 0 || item.collect) R.drawable.ic_action_like else R.drawable.ic_action_no_like
            )
//            .addOnClickListener(R.id.homeItemLike)
    }
}