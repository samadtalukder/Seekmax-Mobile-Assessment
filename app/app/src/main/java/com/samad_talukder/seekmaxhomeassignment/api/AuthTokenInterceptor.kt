package com.samad_talukder.seekmaxhomeassignment.api

import com.samad_talukder.seekmaxhomeassignment.utils.SharedPref
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/**
 * Interceptor that adds an authorization header with a token obtained from [sharedPref].
 **/
class AuthTokenInterceptor @Inject constructor(
    private val sharedPref: SharedPref,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = sharedPref.token
        val request = chain.request().newBuilder()
        request.addHeader("Authorization", "$token")
        return chain.proceed(request.build())
    }
}