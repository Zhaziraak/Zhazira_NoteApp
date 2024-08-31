package com.example.zhazi_4_2_hw.ui.fragments.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.zhazi_4_2_hw.R
import com.example.zhazi_4_2_hw.databinding.FragmentOnBoardBinding
import com.example.zhazi_4_2_hw.databinding.FragmentOnBoardPagingBinding
import com.example.zhazi_4_2_hw.ui.adapter.OnBoardAdapter
import com.example.zhazi_4_2_hw.utils.PreferenceHelper
import com.google.android.material.tabs.TabLayoutMediator


class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtStart.setOnClickListener {
            findNavController().navigate(R.id.noteFragment)
        }
        initialize()
        setupListeners()
        tabLayout()
        click()
    }




    private fun initialize() {
        binding.viewpager2.adapter = OnBoardAdapter(this)
        PreferenceHelper.unit(requireContext())
    }

    private fun setupListeners() = with(binding.viewpager2) {
        registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        binding.txtSkip.visibility = View.VISIBLE
                        binding.txtStart.visibility = View.INVISIBLE
                    }

                    1 -> {
                        binding.txtSkip.visibility = View.VISIBLE
                        binding.txtStart.visibility = View.INVISIBLE
                    }

                    2 -> {
                        binding.txtSkip.visibility = View.INVISIBLE
                        binding.txtStart.visibility = View.VISIBLE
                    }
                }
                super.onPageSelected(position)
            }
        })
        saveSharPref()
    }

    private fun saveSharPref() {
        PreferenceHelper.onBoardShow = true
    }

    private fun tabLayout() = with(binding) {
        TabLayoutMediator(tabLayout, viewpager2) { tab, position -> }.attach()
    }

    private fun click() = with(binding.viewpager2) {
        binding.txtSkip.setOnClickListener {
            if (currentItem < 3) {
                setCurrentItem(currentItem + 2, true)
            }
        }
        binding.txtStart.setOnClickListener {
            if (binding.viewpager2.currentItem == 2) {
                findNavController().navigate(R.id.noteFragment)
            }
        }
    }
}

