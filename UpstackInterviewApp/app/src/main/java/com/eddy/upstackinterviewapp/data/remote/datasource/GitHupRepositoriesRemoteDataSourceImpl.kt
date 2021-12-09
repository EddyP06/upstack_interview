package com.eddy.upstackinterviewapp.data.remote.datasource

import com.eddy.upstackinterviewapp.data.models.RepositoryResponse
import com.eddy.upstackinterviewapp.data.remote.network.GitHubApiClient
import retrofit2.Response

class GitHupRepositoriesRemoteDataSourceImpl(
    private val apiClient: GitHubApiClient
) : GitHubRepositoryRemoteDataSource {

    override suspend fun getUserRepo(): Response<List<RepositoryResponse>> =
        apiClient.getUserRepositories()
}