package com.eddy.upstackinterviewapp.ui.features.login

import androidx.lifecycle.ViewModel
import com.eddy.upstackinterviewapp.domain.usecase.LoginUseCase

class LoginVIewModel(
    private val useCase: LoginUseCase
) : ViewModel() {

    fun storeCredentials(token: String, username: String) {
        useCase.setToken(token)
        useCase.setUsername(username)
    }
}