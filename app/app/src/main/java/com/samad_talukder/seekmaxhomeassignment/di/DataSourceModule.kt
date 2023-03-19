package com.samad_talukder.seekmaxhomeassignment.di

import com.samad_talukder.seekmaxhomeassignment.api.SeeksMaxApi
import com.samad_talukder.seekmaxhomeassignment.data.remote.auth.AuthDataSource
import com.samad_talukder.seekmaxhomeassignment.data.remote.auth.AuthDataSourceImpl
import com.samad_talukder.seekmaxhomeassignment.data.remote.home.HomeDataSource
import com.samad_talukder.seekmaxhomeassignment.data.remote.home.HomeDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Module that provides the [AuthDataSource], [HomeDataSource] implementation.
 * Uses [SeeksMaxApi] to perform the authentication, job list, etc requests.
 */

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    fun provideAuthDataSource(seeksMaxApi: SeeksMaxApi): AuthDataSource {
        return AuthDataSourceImpl(seeksMaxApi)
    }

    @Singleton
    @Provides
    fun provideHomeDataSource(seeksMaxApi: SeeksMaxApi): HomeDataSource {
        return HomeDataSourceImpl(seeksMaxApi)
    }
}