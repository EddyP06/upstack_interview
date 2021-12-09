package com.eddy.upstackinterviewapp.data.local.di

import android.content.Context
import com.eddy.upstackinterviewapp.data.local.SHARED_PREF_NAME
import com.eddy.upstackinterviewapp.data.local.datasource.LocalDataSource
import com.eddy.upstackinterviewapp.data.local.datasource.LocalDataSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localModule = module {
    single {
        androidContext().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
    }

    single<LocalDataSource> {
        LocalDataSourceImpl(sharedPreferences = get())
    }
}