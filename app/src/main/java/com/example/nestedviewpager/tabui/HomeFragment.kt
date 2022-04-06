package com.example.nestedviewpager.tabui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nestedviewpager.databinding.HomeFragmentBinding
import com.example.nestedviewpager.adapter.TopViewPagerAdapter


class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }
    private lateinit var vpadapter: TopViewPagerAdapter
    private lateinit var viewModel: HomeViewModel
    private var _binding: HomeFragmentBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        vpadapter = TopViewPagerAdapter(requireActivity().supportFragmentManager, lifecycle)
        binding.viewPager2.adapter = vpadapter
        binding.aoSignDotIndicator.setViewPager2(binding.viewPager2)


    }

}