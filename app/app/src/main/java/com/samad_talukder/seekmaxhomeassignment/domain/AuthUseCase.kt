package com.samad_talukder.seekmaxhomeassignment.domain

import android.content.Context
import com.samad_talukder.seekmaxhomeassignment.data.repository.auth.AuthRepository
import com.samad_talukder.seekmaxhomeassignment.domain.model.LoginRequest

/**
 * The use case for authenticating a user.
 * @property authRepository The repository for making network calls.
 */

class AuthUseCase(private val authRepository: AuthRepository) {
    suspend fun execute(context: Context, loginRequest: LoginRequest) =
        authRepository.login(context, loginRequest)
}