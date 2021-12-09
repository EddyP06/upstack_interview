package com.eddy.upstackinterviewapp.data.local.datasource

import android.content.SharedPreferences
import com.eddy.upstackinterviewapp.data.local.ACCESS_TOKEN_KEY
import com.eddy.upstackinterviewapp.data.local.USERNAME_KEY

internal class LocalDataSourceImpl(
    private val sharedPreferences: SharedPreferences
) : LocalDataSource {
    override fun setToken(token: String) {
        sharedPreferences.edit().putString(ACCESS_TOKEN_KEY, token).apply()
    }

    override fun getToken(): String = sharedPreferences.getString(ACCESS_TOKEN_KEY, "") ?: ""

    override fun setUsername(name: String) {
        sharedPreferences.edit().putString(USERNAME_KEY, name).apply()
    }

    override fun getUsername(): String = sharedPreferences.getString(USERNAME_KEY, "") ?: ""

}