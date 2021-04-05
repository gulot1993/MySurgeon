package com.example.mysurgeon.core

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.mysurgeon.model.Login
import com.google.gson.Gson

class PreferenceHelper(val sharedPreferences: SharedPreferences) {

    fun setString(key: String, defValue: String?) {
        sharedPreferences.edit { putString(key, defValue) }
    }

    fun getString(key: String, defValue: String?): String? = sharedPreferences.getString(key, defValue)

    fun setBoolean(key: String, defValue: Boolean) {
        sharedPreferences.edit { putBoolean(key, defValue) }
    }

    fun getBoolean(key: String, defValue: Boolean): Boolean = sharedPreferences.getBoolean(key, defValue)

    fun clear() {
        sharedPreferences.edit().clear().commit()
    }

    companion object {

        private var ourInstance: PreferenceHelper? = null
        const val IS_LOGGED_IN = "isLoggedIn"
        const val LOGIN_INFO = "login_info"
        fun getInstance(context: Context): PreferenceHelper{
            if (ourInstance == null) {
                ourInstance = PreferenceHelper(context.getSharedPreferences(
                    "mysurgeon_preferences",
                    Context.MODE_PRIVATE
                ))
            }
            return ourInstance!!
        }
    }

    var isLoggedIn: Boolean
        get() = getBoolean(IS_LOGGED_IN, false)
        set(value) {
            setBoolean(IS_LOGGED_IN, value)
        }

    var loginInfo: Login?
        get() {
            val raw = getString(LOGIN_INFO, null)
            return Gson().fromJson(raw, Login::class.java)
        }
        set(value) {
            val raw = Gson().toJson(value)
            setString(LOGIN_INFO, raw)
        }
}