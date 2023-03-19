package com.samad_talukder.seekmaxhomeassignment.domain

import android.content.Context
import com.samad_talukder.seekmaxhomeassignment.data.repository.auth.AuthRepository
import com.samad_talukder.seekmaxhomeassignment.domain.model.LoginRequest

/**
 * Created by Samad Talukder on 18 March 2023.
 * github.com/samadtalukder
 **/

class AuthUseCase(private val authRepository: AuthRepository) {
    suspend fun execute(context: Context, loginRequest: LoginRequest) =
        authRepository.login(context, loginRequest)
}