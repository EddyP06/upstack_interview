package com.eddy.upstackinterviewapp.data.repository.di

import com.eddy.upstackinterviewapp.data.repository.Repository
import com.eddy.upstackinterviewapp.data.repository.RepositoryImpl
import org.koin.dsl.module

val repoModule = module {
    factory<Repository> {
        RepositoryImpl(
            localDataSource = get(),
            remoteDataSource = get()
        )
    }
}