package com.eddy.upstackinterviewapp.ui.features.login.di

import com.eddy.upstackinterviewapp.ui.features.login.LoginVIewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {
    viewModel<LoginVIewModel> {
        LoginVIewModel(get(), get())
    }
}