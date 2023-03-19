package com.samad_talukder.seekmaxhomeassignment.data.remote.auth

import com.samad_talukder.seekmaxhomeassignment.api.SeeksMaxApi
import com.samad_talukder.seekmaxhomeassignment.domain.model.LoginRequest
import com.samad_talukder.seekmaxhomeassignment.domain.model.LoginResponse
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Samad Talukder on 18 March 2023.
 * github.com/samadtalukder
 **/

class AuthDataSourceImpl @Inject constructor(private var seeksMaxApi: SeeksMaxApi) :
    AuthDataSource {

    override suspend fun login(loginRequest: LoginRequest): Response<LoginResponse> {
        return seeksMaxApi.login(loginRequest)
    }

}