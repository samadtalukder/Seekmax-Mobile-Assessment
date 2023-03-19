package com.samad_talukder.seekmaxhomeassignment.data.remote.auth

import com.samad_talukder.seekmaxhomeassignment.domain.model.LoginRequest
import com.samad_talukder.seekmaxhomeassignment.domain.model.LoginResponse
import retrofit2.Response

/**
 * Created by Samad Talukder on 18 March 2023.
 * github.com/samadtalukder
 **/

interface AuthDataSource {
    suspend fun login(loginRequest: LoginRequest): Response<LoginResponse>
}