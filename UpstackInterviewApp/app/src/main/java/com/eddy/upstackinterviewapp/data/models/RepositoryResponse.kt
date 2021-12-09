package com.eddy.upstackinterviewapp.data.models

import com.google.gson.annotations.SerializedName

data class RepositoryResponse(
    @SerializedName("name")
    val name: String?
)
