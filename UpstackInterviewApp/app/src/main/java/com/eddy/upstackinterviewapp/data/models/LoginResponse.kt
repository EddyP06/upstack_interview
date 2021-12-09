package com.eddy.upstackinterviewapp.data.models

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("login")
    val message: String?
)