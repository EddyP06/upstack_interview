package com.eddy.upstackinterviewapp.data.remote.datasource

import com.eddy.upstackinterviewapp.data.models.LoginResponse
import com.eddy.upstackinterviewapp.data.models.RepositoryResponse
import retrofit2.Response

interface GitHubRepositoryRemoteDataSource {
    suspend fun getUserRepo(): Response<List<RepositoryResponse>>
    suspend fun login(): Response<LoginResponse>
}