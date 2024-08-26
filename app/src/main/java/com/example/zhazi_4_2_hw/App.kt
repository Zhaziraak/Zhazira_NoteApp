package com.example.zhazi_4_2_hw

import android.app.Application
import com.example.zhazi_4_2_hw.utils.PreferenceHelper

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        val sharedPreferences = PreferenceHelper
        sharedPreferences.unit(this)
    }
}