package com.samad_talukder.seekmaxhomeassignment.data.repository.home

import com.samad_talukder.seekmaxhomeassignment.api.ApiResult
import com.samad_talukder.seekmaxhomeassignment.api.BaseApiResponse
import com.samad_talukder.seekmaxhomeassignment.data.remote.home.HomeDataSource
import com.samad_talukder.seekmaxhomeassignment.data.repository.auth.AuthRepository
import com.samad_talukder.seekmaxhomeassignment.domain.model.AllJobListResponse
import com.samad_talukder.seekmaxhomeassignment.domain.model.Jobs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Implementation of [HomeRepository] that handles job related operations
 * @property homeDataSource Data source for job API calls
 */

class HomeRepositoryImpl @Inject constructor(private val homeDataSource: HomeDataSource) :
    BaseApiResponse(), HomeRepository {
    override suspend fun getAllJobList(
        page: String,
        perPage: String
    ): Flow<ApiResult<AllJobListResponse>> {
        return flow {
            emit(
                safeApiCall { homeDataSource.getAllJobList(page, perPage) }
            )
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getJobDetailsByID(jobID: String): Flow<ApiResult<Jobs>> {
        return flow {
            emit(
                safeApiCall { homeDataSource.getJobDetailsByID(jobID) }
            )
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getUserByID(): Flow<ApiResult<Jobs>> {
        return flow {
            emit(
                safeApiCall { homeDataSource.getUserByID() }
            )
        }.flowOn(Dispatchers.IO)
    }


}