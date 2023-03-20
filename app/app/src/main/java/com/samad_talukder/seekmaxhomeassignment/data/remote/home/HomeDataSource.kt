package com.samad_talukder.seekmaxhomeassignment.data.remote.home

import com.samad_talukder.seekmaxhomeassignment.domain.model.AllJobListResponse
import com.samad_talukder.seekmaxhomeassignment.domain.model.Jobs
import com.samad_talukder.seekmaxhomeassignment.domain.model.LoginRequest
import com.samad_talukder.seekmaxhomeassignment.domain.model.LoginResponse
import retrofit2.Response

/**
 * Data source interface for job related API calls.
 */

interface HomeDataSource {
    suspend fun getAllJobList(page: Int): Response<AllJobListResponse>
    suspend fun getJobDetailsByID(jobID: String): Response<Jobs>
    suspend fun getUserByID(): Response<Jobs>
}