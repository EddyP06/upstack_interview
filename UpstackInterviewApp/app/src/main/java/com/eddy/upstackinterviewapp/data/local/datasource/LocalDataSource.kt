package com.eddy.upstackinterviewapp.data.local.datasource

interface LocalDataSource {
    fun setToken(token: String)
    fun getToken(): String
    fun setUsername(name: String)
    fun getUsername(): String
}