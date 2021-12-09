package com.eddy.upstackinterviewapp.data.remote.network

import com.eddy.upstackinterviewapp.data.models.LoginResponse
import com.eddy.upstackinterviewapp.data.models.RepositoryResponse
import retrofit2.Response
import retrofit2.http.GET

interface GitHubApiClient {

    @GET(REPOS_ENDPOINT)
    suspend fun getUserRepositories(): Response<List<RepositoryResponse>>

    @GET(LOGIN_ENDPOINT)
    suspend fun login(): Response<LoginResponse>
}