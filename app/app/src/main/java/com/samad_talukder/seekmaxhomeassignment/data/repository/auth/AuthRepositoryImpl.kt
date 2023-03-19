package com.samad_talukder.seekmaxhomeassignment.data.repository.auth

import android.content.Context
import com.samad_talukder.seekmaxhomeassignment.api.ApiResult
import com.samad_talukder.seekmaxhomeassignment.api.BaseApiResponse
import com.samad_talukder.seekmaxhomeassignment.data.remote.auth.AuthDataSource
import com.samad_talukder.seekmaxhomeassignment.domain.model.LoginRequest
import com.samad_talukder.seekmaxhomeassignment.domain.model.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Implementation of [AuthRepository] that handles user authentication related operations
 * @property authDataSource Data source for authentication API calls
 */

class AuthRepositoryImpl @Inject constructor(private val authDataSource: AuthDataSource) :
    BaseApiResponse(), AuthRepository {

    override suspend fun login(
        context: Context,
        loginRequest: LoginRequest
    ): Flow<ApiResult<LoginResponse>> {
        return flow {
            emit(
                safeApiCall { authDataSource.login(loginRequest) }
            )
        }.flowOn(Dispatchers.IO)
    }
}