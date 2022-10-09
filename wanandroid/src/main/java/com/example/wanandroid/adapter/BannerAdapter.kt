package com.example.wanandroid.adapter

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.wanandroid.R
import com.example.wanandroid.bean.BannerResponse

class BannerAdapter(context: Context, datas: MutableList<BannerResponse.Data>) :
    BaseQuickAdapter<BannerResponse.Data, BaseViewHolder>(R.layout.banner_item, datas) {
    override fun convert(holder: BaseViewHolder, item: BannerResponse.Data) {
        holder.setText(R.id.bannerTitle, item.title.trim())
        val imageView = holder.getView<ImageView>(R.id.bannerImage)
        Glide.with(context).load(item.imagePath).placeholder(R.drawable.logo).into(imageView)
    }
}