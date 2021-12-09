package com.eddy.upstackinterviewapp.ui.features.repo.di

import com.eddy.upstackinterviewapp.ui.features.repo.RepoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repoFeatureModule = module {
    viewModel {
        RepoViewModel(get(), get())
    }
}