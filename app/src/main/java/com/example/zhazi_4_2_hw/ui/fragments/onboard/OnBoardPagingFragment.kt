package com.example.zhazi_4_2_hw.ui.fragments.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zhazi_4_2_hw.R
import com.example.zhazi_4_2_hw.databinding.FragmentOnBoardPagingBinding


class OnBoardPagingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardPagingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardPagingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inintialize()
    }

    private fun inintialize() = with(binding) {
        when(requireArguments().getInt(ARG_ONBOARD_POSITION)){
            0 -> {
                txtOnboard.text = "Очень удобный функционал"
                lottieAnimation.setAnimation(R.raw.lottie1)
            }
            1 -> {
                txtOnboard.text = "Быстрый, качественный продукт"
                lottieAnimation.setAnimation(R.raw.lottie2)
            }
            2 -> {
                txtOnboard.text = "Куча функций и интересных фишек"
                lottieAnimation.setAnimation(R.raw.lottie3)
            }
        }

    }

    companion object {
        const val ARG_ONBOARD_POSITION = "onBoardPosition"
    }

}