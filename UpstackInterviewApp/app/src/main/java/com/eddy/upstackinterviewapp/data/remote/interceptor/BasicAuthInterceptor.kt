package com.eddy.upstackinterviewapp.data.remote.interceptor

import com.eddy.upstackinterviewapp.data.local.datasource.LocalDataSource
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

class BasicAuthInterceptor(private val localDataSource: LocalDataSource): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()
        builder.addHeader("Authorization", "token ${localDataSource.getToken()}")
        return chain.proceed(builder.build())
    }
}