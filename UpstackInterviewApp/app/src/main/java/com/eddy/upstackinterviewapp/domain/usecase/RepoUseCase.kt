package com.eddy.upstackinterviewapp.domain.usecase

import com.eddy.upstackinterviewapp.data.entity.RepositoryEntity
import com.eddy.upstackinterviewapp.data.repository.utils.Resource
import kotlinx.coroutines.flow.Flow

interface RepoUseCase {
    fun getUserRepos(): Flow<Resource<List<RepositoryEntity>>>
}