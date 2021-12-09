package com.eddy.upstackinterviewapp.domain.di

import com.eddy.upstackinterviewapp.domain.dispatchers.AppDispatchers
import com.eddy.upstackinterviewapp.domain.usecase.LoginUseCase
import com.eddy.upstackinterviewapp.domain.usecase.LoginUseCaseImpl
import com.eddy.upstackinterviewapp.domain.usecase.RepoUseCase
import com.eddy.upstackinterviewapp.domain.usecase.RepoUserCaseImpl
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val domainModule = module {
    factory {
        AppDispatchers(
            Dispatchers.IO,
            Dispatchers.Main,
            Dispatchers.Unconfined,
            Dispatchers.Default
        )
    }

    factory<LoginUseCase> {
        LoginUseCaseImpl(get())
    }

    factory<RepoUseCase> {
        RepoUserCaseImpl(get())
    }
}