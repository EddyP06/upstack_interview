package com.eddy.upstackinterviewapp.domain.usecase

import com.eddy.upstackinterviewapp.data.repository.Repository

class LoginUseCaseImpl(
    private val repository: Repository
) : LoginUseCase {
    override fun setToken(token: String) {
        repository.setToken(token)
    }

    override fun setUsername(username: String) {
        repository.setUsername(username)
    }

}