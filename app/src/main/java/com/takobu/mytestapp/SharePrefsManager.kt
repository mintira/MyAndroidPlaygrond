package com.takobu.mytestapp

import android.content.Context
import androidx.core.content.edit

class SharePrefsManager(context: Context) {
    private val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

    fun putString(key: String, value: String) {
        prefs.edit { putString(key, value) }
    }

    fun getString(key: String, defaultValue: String? = null): String? {
        return prefs.getString(key, defaultValue)
    }

    fun putBoolean(key: String, value: Boolean) {
        prefs.edit { putBoolean(key, value) }
    }

    fun getBoolean(key: String, value: Boolean = false): Boolean {
        return prefs.getBoolean(key, value)
    }

}