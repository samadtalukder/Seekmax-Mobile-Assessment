package com.samad_talukder.seekmaxhomeassignment.data.remote.auth

import com.samad_talukder.seekmaxhomeassignment.api.SeeksMaxApi
import com.samad_talukder.seekmaxhomeassignment.domain.model.LoginRequest
import com.samad_talukder.seekmaxhomeassignment.domain.model.LoginResponse
import retrofit2.Response
import javax.inject.Inject

/**
 * Implementation of [AuthDataSource] interface that communicates with the remote API using [SeeksMaxApi].
 * @param seeksMaxApi An instance of [SeeksMaxApi] used to communicate with the remote API.
 */

class AuthDataSourceImpl @Inject constructor(private var seeksMaxApi: SeeksMaxApi) :
    AuthDataSource {

    override suspend fun login(loginRequest: LoginRequest): Response<LoginResponse> {
        return seeksMaxApi.login(loginRequest)
    }

}