package com.samad_talukder.seekmaxhomeassignment.data.repository.auth

import android.content.Context
import com.samad_talukder.seekmaxhomeassignment.api.ApiResult
import com.samad_talukder.seekmaxhomeassignment.domain.model.LoginRequest
import com.samad_talukder.seekmaxhomeassignment.domain.model.LoginResponse
import kotlinx.coroutines.flow.Flow

/**
 * Interface for the authentication repository.
 */

interface AuthRepository {
    suspend fun login(context: Context, loginRequest: LoginRequest): Flow<ApiResult<LoginResponse>>
}