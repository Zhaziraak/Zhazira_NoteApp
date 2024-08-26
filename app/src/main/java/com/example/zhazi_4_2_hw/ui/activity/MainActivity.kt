package com.example.zhazi_4_2_hw.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.zhazi_4_2_hw.R
import com.example.zhazi_4_2_hw.databinding.ActivityMainBinding
import com.example.zhazi_4_2_hw.utils.PreferenceHelper

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment

        navController = NavHostFragment.navController

        if (PreferenceHelper.onBoardShow == true){
            navController.navigate(R.id.noteFragment)
        }else{
            navController.navigate(R.id.onBoardFragment)
        }
    }
}