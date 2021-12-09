package com.eddy.upstackinterviewapp.domain.usecase

interface LoginUseCase {
    fun setToken(token: String)
    fun setUsername(username: String)
}