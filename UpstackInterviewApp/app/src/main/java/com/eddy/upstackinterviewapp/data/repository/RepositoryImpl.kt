package com.eddy.upstackinterviewapp.data.repository

import com.eddy.upstackinterviewapp.data.entity.RepositoryEntity
import com.eddy.upstackinterviewapp.data.local.datasource.LocalDataSource
import com.eddy.upstackinterviewapp.data.mapper.repositoryToEntity
import com.eddy.upstackinterviewapp.data.remote.datasource.GitHubRepositoryRemoteDataSource
import com.eddy.upstackinterviewapp.data.repository.utils.Resource
import com.eddy.upstackinterviewapp.data.repository.utils.safeApiCall
import kotlinx.coroutines.flow.Flow

internal class RepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: GitHubRepositoryRemoteDataSource
) : Repository {
    override fun setUsername(username: String) = localDataSource.setUsername(username)

    override fun setToken(token: String) = localDataSource.setToken(token)

    override fun getUserRepos(): Flow<Resource<List<RepositoryEntity>>> =
        safeApiCall(
            apiCall = { remoteDataSource.getUserRepo() },
            mapper = ::repositoryToEntity
        )
}