package com.eddy.upstackinterviewapp.data.repository.utils

import com.eddy.upstackinterviewapp.data.repository.exception.NetworkException
import kotlinx.coroutines.flow.*
import retrofit2.Response
import java.net.UnknownHostException

inline fun <RESPONSE, RESULT> safeApiCall(
    crossinline apiCall: suspend () -> Response<RESPONSE>,
    crossinline mapper: (RESPONSE) -> RESULT
): Flow<Resource<RESULT>> = flow {
    emit(Resource.Loading(null))
    try {
        val responseResult = apiCall.invoke()
        if (responseResult.isSuccessful) {
            responseResult.body()?.let {
                emit(Resource.Success(mapper(it)))
            }
        } else {
            emit(Resource.Error(Exception("error"), null))
        }
    } catch (t: Throwable) {
        val exception = when (t) {
            is UnknownHostException -> {
                NetworkException()
            }
            else -> {
                Exception("Could not fetch from network")
            }
        }
        emit(Resource.Error(exception = exception, null))
    }
}
