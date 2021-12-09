package com.eddy.upstackinterviewapp.ui.features.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eddy.upstackinterviewapp.data.entity.LoginEntity
import com.eddy.upstackinterviewapp.data.entity.RepositoryEntity
import com.eddy.upstackinterviewapp.data.repository.utils.Resource
import com.eddy.upstackinterviewapp.domain.dispatchers.AppDispatchers
import com.eddy.upstackinterviewapp.domain.usecase.LoginUseCase
import com.eddy.upstackinterviewapp.domain.usecase.RepoUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class LoginVIewModel(
    private val dispatchers: AppDispatchers,
    private val useCase: LoginUseCase
) : ViewModel() {

    private val _listData = MutableLiveData<LoginEntity>()
    val listData: LiveData<LoginEntity> = _listData

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    fun storeCredentials(token: String, username: String) {
        useCase.setToken(token)
        useCase.setUsername(username)
    }

    fun login() {
        useCase.login().catch {
            _errorMessage.postValue("Error occur please log out and try again")
        }.flowOn(dispatchers.ioDispatchers)
            .onEach {
                when (it) {
                    is Resource.Error -> _errorMessage.postValue(it.exception.message)
                    is Resource.Loading -> Unit // emit loading
                    is Resource.Success -> {
                        _listData.postValue(it.data ?: LoginEntity("no data"))
                    }
                }
            }
            .flowOn(dispatchers.mainDispatchers)
            .launchIn(viewModelScope)
    }
}