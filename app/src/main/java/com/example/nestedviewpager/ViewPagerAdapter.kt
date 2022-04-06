package com.example.nestedviewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle


class ViewPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
) :
    NavigableFragmentStateAdapter(fragmentManager, lifecycle) {
    private val list: MutableList<Fragment> = mutableListOf()

    init {
        list.clear()
        list.add(HomeFragment())
        list.add(JobsFragment())
        list.add(DocumentsFragment())
        list.add(AppointmentsFragment())
    }

    val getFragmentList: MutableList<Fragment>
        get() = list as ArrayList<Fragment>

    override fun getItemCount(): Int = list.size

    override fun createFragment(position: Int): Fragment = list[position]
}