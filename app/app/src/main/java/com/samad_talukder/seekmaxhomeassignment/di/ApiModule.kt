package com.samad_talukder.seekmaxhomeassignment.di


import com.samad_talukder.seekmaxhomeassignment.BuildConfig
import com.samad_talukder.seekmaxhomeassignment.api.AuthTokenInterceptor
import com.samad_talukder.seekmaxhomeassignment.api.SeeksMaxApi
import com.samad_talukder.seekmaxhomeassignment.utils.AuthTokenManager
import com.samad_talukder.seekmaxhomeassignment.utils.Constants
import com.samad_talukder.seekmaxhomeassignment.utils.SharedPref
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Dagger Hilt module for providing API related dependencies.
 * This module provides dependencies such as [AuthTokenManager], [HttpLoggingInterceptor],
 * [AuthTokenInterceptor], [GsonConverterFactory], [OkHttpClient], [Retrofit] and [SeeksMaxApi].
 * @constructor Creates an instance of [ApiModule].
 **/

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideAuthTokenManager(sharedPref: SharedPref): AuthTokenManager =
        AuthTokenManager(sharedPref)

    @Singleton
    @Provides
    fun provideHttpInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()

        if (BuildConfig.DEBUG) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        }

        return loggingInterceptor
    }

    @Singleton
    @Provides
    fun provideAuthTokenInterceptor(tokenManager: SharedPref): AuthTokenInterceptor = AuthTokenInterceptor(tokenManager)

    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideOkHttpClient(
        authTokenInterceptor: AuthTokenInterceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authTokenInterceptor)
            .addInterceptor(loggingInterceptor)
            .connectTimeout(Constants.CONNECTION_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(Constants.READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(Constants.WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.REST_API)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): SeeksMaxApi =
        retrofit.create(SeeksMaxApi::class.java)
}