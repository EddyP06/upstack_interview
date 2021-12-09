package com.eddy.upstackinterviewapp.data.repository

import com.eddy.upstackinterviewapp.data.entity.RepositoryEntity
import com.eddy.upstackinterviewapp.data.repository.utils.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun setUsername(username: String)
    fun setToken(token: String)
    fun getUserRepos(): Flow<Resource<List<RepositoryEntity>>>
}