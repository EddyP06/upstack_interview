package com.eddy.upstackinterviewapp.ui

import android.app.Application
import com.eddy.upstackinterviewapp.data.local.di.localModule
import com.eddy.upstackinterviewapp.data.remote.di.remoteModule
import com.eddy.upstackinterviewapp.data.repository.di.repoModule
import com.eddy.upstackinterviewapp.domain.di.domainModule
import com.eddy.upstackinterviewapp.ui.features.login.di.loginModule
import com.eddy.upstackinterviewapp.ui.features.repo.di.repoFeatureModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(
                localModule,
                remoteModule,
                repoModule,
                domainModule,
                loginModule,
                repoFeatureModule
            ))
        }
    }
}