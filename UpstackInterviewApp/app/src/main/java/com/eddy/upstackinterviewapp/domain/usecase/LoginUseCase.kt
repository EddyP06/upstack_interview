package com.eddy.upstackinterviewapp.domain.usecase

import com.eddy.upstackinterviewapp.data.entity.LoginEntity
import com.eddy.upstackinterviewapp.data.repository.utils.Resource
import java.util.concurrent.Flow

interface LoginUseCase {
    fun setToken(token: String)
    fun setUsername(username: String)
    fun login(): kotlinx.coroutines.flow.Flow<Resource<LoginEntity>>
    fun isLoggedIn(): Boolean
}