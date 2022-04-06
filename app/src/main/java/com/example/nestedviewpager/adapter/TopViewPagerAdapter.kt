package com.example.nestedviewpager.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import com.example.nestedviewpager.topsliderfragment.FragmentOne
import com.example.nestedviewpager.topsliderfragment.FragmentThree
import com.example.nestedviewpager.topsliderfragment.FragmentTwo


class TopViewPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
) :
    NavigableFragmentStateAdapter(fragmentManager, lifecycle) {
    private val list: MutableList<Fragment> = mutableListOf()

    init {
        list.clear()
        list.add(FragmentOne())
        list.add(FragmentTwo())
        list.add(FragmentThree())
    }

    val getFragmentList: MutableList<Fragment>
        get() = list as ArrayList<Fragment>

    override fun getItemCount(): Int = list.size

    override fun createFragment(position: Int): Fragment = list[position]
}