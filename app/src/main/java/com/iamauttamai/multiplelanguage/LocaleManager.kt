package com.iamauttamai.multiplelanguage

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.res.Configuration
import java.util.*

/**
 * Created by AuttaphonL. on 08,June,2023
 */

class LocaleManager(base: Context?) : ContextWrapper(base) {

    // Setting language in application
    // Support
    //  TH (Thailand)
    //  EN (English (US))

    private fun lang(): String? {
        val preferences = this.applicationContext.getSharedPreferences("language", MODE_PRIVATE)
        return preferences.getString("select_l", "th")
    }

    fun isTH(): Boolean {
        return lang()!!.startsWith("th")
    }

    companion object {
        fun setLocale(context: Context): LocaleManager {
            var context = context
            val configuration = setLang(context, lang(context))
            context = context.createConfigurationContext(configuration)
            return LocaleManager(context)
        }

        private fun lang(context: Context): String? {
            val preferences = context.getSharedPreferences("language", MODE_PRIVATE)
            return preferences.getString("select_l", "th")
        }

        private fun setLang(context: Context, lang: String?): Configuration {
            val configuration = context.resources.configuration
            val locale = Locale(lang)
            Locale.setDefault(locale)
            configuration.setLocale(locale)
            return configuration
        }

        fun setLocale(activity: Activity) {
            val locale = Locale(lang(activity))
            Locale.setDefault(locale)
            val resources = activity.resources
            val config = resources.configuration
            config.setLocale(locale)
            resources.updateConfiguration(config, resources.displayMetrics)
        }
    }
}