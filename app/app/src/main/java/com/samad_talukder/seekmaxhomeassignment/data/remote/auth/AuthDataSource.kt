package com.samad_talukder.seekmaxhomeassignment.data.remote.auth

import com.samad_talukder.seekmaxhomeassignment.domain.model.LoginRequest
import com.samad_talukder.seekmaxhomeassignment.domain.model.LoginResponse
import retrofit2.Response

/**
 * Data source interface for authentication related API calls.
 */

interface AuthDataSource {
    suspend fun login(loginRequest: LoginRequest): Response<LoginResponse>
}