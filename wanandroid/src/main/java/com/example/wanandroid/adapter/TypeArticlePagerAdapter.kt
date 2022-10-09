package com.example.wanandroid.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.example.wanandroid.bean.TreeListResponse.Data.Children
import com.example.wanandroid.ui.fragment.TypeArticleFragment

class TypeArticlePagerAdapter(val list: List<Children>, fm: FragmentManager) :
    FragmentStatePagerAdapter(fm) {
    private val listFragment = mutableListOf<Fragment>()

    init {
        list.forEach { listFragment.add(TypeArticleFragment.newInstance(it.id)) }
    }

    override fun getItem(position: Int): Fragment = listFragment[position]

    override fun getCount(): Int = list.size

    override fun getPageTitle(position: Int): CharSequence = list[position].name

    override fun getItemPosition(`object`: Any): Int = PagerAdapter.POSITION_NONE
}