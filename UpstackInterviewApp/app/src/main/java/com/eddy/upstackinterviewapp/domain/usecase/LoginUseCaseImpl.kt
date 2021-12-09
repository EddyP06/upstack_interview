package com.eddy.upstackinterviewapp.domain.usecase

import com.eddy.upstackinterviewapp.data.entity.LoginEntity
import com.eddy.upstackinterviewapp.data.repository.Repository
import com.eddy.upstackinterviewapp.data.repository.utils.Resource
import kotlinx.coroutines.flow.Flow

class LoginUseCaseImpl(
    private val repository: Repository
) : LoginUseCase {
    override fun setToken(token: String) {
        repository.setToken(token)
    }

    override fun setUsername(username: String) {
        repository.setUsername(username)
    }

    override fun login(): Flow<Resource<LoginEntity>> =
        repository.login()

}