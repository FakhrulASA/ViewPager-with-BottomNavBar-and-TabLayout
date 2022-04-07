package com.example.nestedviewpager.tabui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.nestedviewpager.R
import com.example.nestedviewpager.adapter.ViewPagerAdapter
import com.example.nestedviewpager.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var vpadapter: ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        vpadapter = ViewPagerAdapter(this.supportFragmentManager, lifecycle)
        binding.viewPager.adapter = vpadapter
        binding.tabLayout.setupWithViewPager2(binding.viewPager)
        binding.viewPager.isUserInputEnabled = false

//        binding.bottomNavigation.setOnItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.page_1 -> {
//                    binding.viewPager.currentItem = 0
//                    return@setOnItemSelectedListener true
//                }
//                R.id.page_2 -> {
//                    binding.viewPager.currentItem = 1
//                    return@setOnItemSelectedListener true
//                }
//                R.id.page_3 -> {
//                    binding.viewPager.currentItem = 2
//                    return@setOnItemSelectedListener true
//                }
//                R.id.page_4 -> {
//                    binding.viewPager.currentItem = 3
//                    return@setOnItemSelectedListener true
//                }
//                else -> {
//                    return@setOnItemSelectedListener false
//                }
//            }
//        }

    }

    private fun TabLayout.setupWithViewPager2(viewPager: ViewPager2) {
        TabLayoutMediator(
            this, viewPager
        ) { tab, position ->
            if (position == 0) {
                tab.icon = resources.getDrawable(R.drawable.ic_baseline_home_24)
                tab.text = "Home"
            } else if (position == 1) {
                tab.icon = resources.getDrawable(R.drawable.ic_baseline_work_24)
                tab.text = "Jobs"
            } else if (position == 2) {
                tab.icon = resources.getDrawable(R.drawable.ic_baseline_insert_drive_file_24)
                tab.text = "Documents"
            } else if (position == 3) {
                tab.icon = resources.getDrawable(R.drawable.ic_baseline_wifi_calling_24)
                tab.text = "Appointments"
            }

        }.attach()
    }

}