package com.samad_talukder.seekmaxhomeassignment.di

import com.samad_talukder.seekmaxhomeassignment.data.remote.auth.AuthDataSource
import com.samad_talukder.seekmaxhomeassignment.data.remote.home.HomeDataSource
import com.samad_talukder.seekmaxhomeassignment.data.remote.home.HomeDataSourceImpl
import com.samad_talukder.seekmaxhomeassignment.data.repository.auth.AuthRepository
import com.samad_talukder.seekmaxhomeassignment.data.repository.auth.AuthRepositoryImpl
import com.samad_talukder.seekmaxhomeassignment.data.repository.home.HomeRepository
import com.samad_talukder.seekmaxhomeassignment.data.repository.home.HomeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dagger Hilt module that provides instances of the [AuthRepository], [HomeRepository].
 * All instances provided by this module are Singleton-scoped.
 **/

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun providesAuthRepository(authsDataSource: AuthDataSource): AuthRepository {
        return AuthRepositoryImpl(authsDataSource)
    }

    @Singleton
    @Provides
    fun providesHomeRepository(homeDataSource: HomeDataSource): HomeRepository {
        return HomeRepositoryImpl(homeDataSource)
    }
}