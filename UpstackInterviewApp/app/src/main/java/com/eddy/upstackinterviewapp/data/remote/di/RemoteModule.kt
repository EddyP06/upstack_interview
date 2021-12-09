package com.eddy.upstackinterviewapp.data.remote.di

import com.eddy.upstackinterviewapp.data.remote.datasource.GitHubRepositoryRemoteDataSource
import com.eddy.upstackinterviewapp.data.remote.datasource.GitHupRepositoriesRemoteDataSourceImpl
import com.eddy.upstackinterviewapp.data.remote.interceptor.BasicAuthInterceptor
import com.eddy.upstackinterviewapp.data.remote.network.GitHubApiClient
import com.eddy.upstackinterviewapp.data.remote.network.baseUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val remoteModule = module {
    factory<Interceptor> {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    factory<BasicAuthInterceptor> {
        BasicAuthInterceptor(localDataSource = get())
    }

    factory {
        OkHttpClient.Builder().readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(100, TimeUnit.SECONDS)
            .addInterceptor(get<Interceptor>())
            .addInterceptor(get<BasicAuthInterceptor>())
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(GitHubApiClient::class.java)
    }

    single<GitHubRepositoryRemoteDataSource> {
        GitHupRepositoriesRemoteDataSourceImpl(get())
    }
}