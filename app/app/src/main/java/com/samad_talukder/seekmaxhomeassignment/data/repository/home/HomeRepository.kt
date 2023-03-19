package com.samad_talukder.seekmaxhomeassignment.data.repository.home

import com.samad_talukder.seekmaxhomeassignment.api.ApiResult
import com.samad_talukder.seekmaxhomeassignment.domain.model.AllJobListResponse
import com.samad_talukder.seekmaxhomeassignment.domain.model.Jobs
import kotlinx.coroutines.flow.Flow

/**
 * Created by Samad Talukder on 18 March 2023.
 * github.com/samadtalukder
 **/

interface HomeRepository {
    suspend fun getAllJobList(
        page: String,
        perPage: String
    ): Flow<ApiResult<AllJobListResponse>>

    suspend fun getJobDetailsByID(
        jobID: String
    ): Flow<ApiResult<Jobs>>

    suspend fun getUserByID(): Flow<ApiResult<Jobs>>
}