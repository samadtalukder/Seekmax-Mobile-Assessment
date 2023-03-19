package com.samad_talukder.seekmaxhomeassignment.di

import com.samad_talukder.seekmaxhomeassignment.data.repository.auth.AuthRepository
import com.samad_talukder.seekmaxhomeassignment.data.repository.home.HomeRepository
import com.samad_talukder.seekmaxhomeassignment.domain.AuthUseCase
import com.samad_talukder.seekmaxhomeassignment.domain.AllJobListUseCase
import com.samad_talukder.seekmaxhomeassignment.domain.JobDetailsByIDUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Samad Talukder on 18 March 2023.
 * github.com/samadtalukder
 **/

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository): AuthUseCase {
        return AuthUseCase(authRepository)
    }

    @Singleton
    @Provides
    fun provideAllJobListUseCase(homeUseCase: HomeRepository): AllJobListUseCase {
        return AllJobListUseCase(homeUseCase)
    }

    @Singleton
    @Provides
    fun provideJobDetailsByIDUseCase(homeUseCase: HomeRepository): JobDetailsByIDUseCase {
        return JobDetailsByIDUseCase(homeUseCase)
    }
}