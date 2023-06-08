package com.iamauttamai.multiplelanguage

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by AuttaphonL. on 08,June,2023
 */
open class CustomAppCompatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        LocaleManager.setLocale(this)
    }

    override fun attachBaseContext(newBase: Context?) {
        /*
          handle locale
         */
        val lm = LocaleManager.setLocale(newBase!!)
        super.attachBaseContext(lm)
    }

}