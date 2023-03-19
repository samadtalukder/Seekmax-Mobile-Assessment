package com.samad_talukder.seekmaxhomeassignment.ui.auth

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.samad_talukder.seekmaxhomeassignment.api.ApiResult
import com.samad_talukder.seekmaxhomeassignment.domain.AuthUseCase
import com.samad_talukder.seekmaxhomeassignment.domain.model.LoginRequest
import com.samad_talukder.seekmaxhomeassignment.domain.model.LoginResponse
import com.samad_talukder.seekmaxhomeassignment.utils.AuthTokenManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel class responsible for managing authentication-related UI data and events.
 * @property application The [Application] instance used to create the ViewModel.
 * @property authUseCase The [AuthUseCase] used to perform authentication.
 * @property authTokenManager The [AuthTokenManager] used to manage user authentication tokens.
 */

@HiltViewModel
class AuthViewModel @Inject constructor(
    application: Application,
    private val authUseCase: AuthUseCase,
    private val authTokenManager: AuthTokenManager
) : AndroidViewModel(application) {

    private val _loginResponse: MutableLiveData<ApiResult<LoginResponse>> =
        MutableLiveData()
    val loginResponse: LiveData<ApiResult<LoginResponse>> =
        _loginResponse

    fun login(context: Context, loginRequest: LoginRequest) = viewModelScope.launch {
        _loginResponse.value = ApiResult.Loading

        authUseCase.execute(context, loginRequest).collect { values ->
            _loginResponse.value = values
        }
    }


    fun getTokenPref():String? {
        return authTokenManager.getToken()
    }

    fun setTokenPref(token: String) {
        authTokenManager.saveToken(token)
    }

    fun clearTokenPref() {
        authTokenManager.deleteToken()
    }
}

