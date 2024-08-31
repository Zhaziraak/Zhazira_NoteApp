package com.example.zhazi_4_2_hw

import android.app.Application
import androidx.room.Room
import com.example.zhazi_4_2_hw.data.db.AppDatabase
import com.example.zhazi_4_2_hw.utils.PreferenceHelper

class App: Application() {

    companion object{
        var appDatabase: AppDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        val sharedPreferences = PreferenceHelper
        sharedPreferences.unit(this)
        getInstance()
    }

    private fun getInstance(): AppDatabase? {
        if (appDatabase ==null){
            appDatabase = applicationContext?.let{
                Room.databaseBuilder(
                    it,
                    AppDatabase::class.java,
                    "note.database"
                ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
            }
        }
        return appDatabase
    }
}