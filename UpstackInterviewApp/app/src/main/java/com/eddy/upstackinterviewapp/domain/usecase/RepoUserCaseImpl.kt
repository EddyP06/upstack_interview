package com.eddy.upstackinterviewapp.domain.usecase

import com.eddy.upstackinterviewapp.data.entity.RepositoryEntity
import com.eddy.upstackinterviewapp.data.repository.Repository
import com.eddy.upstackinterviewapp.data.repository.utils.Resource
import kotlinx.coroutines.flow.Flow

class RepoUserCaseImpl(
    private val repository: Repository
) : RepoUseCase {
    override fun getUserRepos(): Flow<Resource<List<RepositoryEntity>>> = repository.getUserRepos()
    override fun clearData() {
        repository.setToken("")
        repository.setUsername("")
    }

}