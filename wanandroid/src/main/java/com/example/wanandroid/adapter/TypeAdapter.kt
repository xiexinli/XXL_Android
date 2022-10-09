package com.example.wanandroid.adapter

import android.content.Context
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.wanandroid.R
import com.example.wanandroid.bean.TreeListResponse

class TypeAdapter(context: Context, datas: MutableList<TreeListResponse.Data>) :
    BaseQuickAdapter<TreeListResponse.Data, BaseViewHolder>(R.layout.type_list_item, datas) {
    override fun convert(helper: BaseViewHolder, item: TreeListResponse.Data) {
        item ?: return
        helper.setText(R.id.typeItemFirst, item.name)
        item.children?.let { children ->
            helper.setText(
                R.id.typeItemSecond,
                children.joinToString("     ", transform = { child ->
                    child.name
                })
            )
        }
    }
}