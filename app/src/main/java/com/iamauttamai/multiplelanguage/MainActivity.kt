package com.iamauttamai.multiplelanguage

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.iamauttamai.multiplelanguage.databinding.ActivityMainBinding

class MainActivity : CustomAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTH.setOnClickListener {
            changeLanguage("th")
        }

        binding.btnEN.setOnClickListener {
            changeLanguage("en")
        }

    }

    private fun changeLanguage(s: String) {
        val preferences: SharedPreferences = getSharedPreferences("language", MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putString("select_l", s) // value to store
        editor.apply()
        val i: Intent = packageManager.getLaunchIntentForPackage(packageName)!!
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(i)
    }
}