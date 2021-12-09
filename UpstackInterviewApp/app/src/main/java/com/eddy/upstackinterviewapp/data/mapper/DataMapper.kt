package com.eddy.upstackinterviewapp.data.mapper

import com.eddy.upstackinterviewapp.data.entity.RepositoryEntity
import com.eddy.upstackinterviewapp.data.models.RepositoryResponse

fun repositoryToEntity(repositoryResponse: List<RepositoryResponse>): List<RepositoryEntity> =
    repositoryResponse.map {
        RepositoryEntity(name = it.name ?: "")
    }