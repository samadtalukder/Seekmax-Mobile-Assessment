package com.samad_talukder.seekmaxhomeassignment.api

import com.samad_talukder.seekmaxhomeassignment.domain.model.AllJobListResponse
import com.samad_talukder.seekmaxhomeassignment.domain.model.Jobs
import com.samad_talukder.seekmaxhomeassignment.domain.model.LoginRequest
import com.samad_talukder.seekmaxhomeassignment.domain.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Samad Talukder on 18 March 2023.
 * github.com/samadtalukder
 **/

interface SeeksMaxApi {

    @POST("auth")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): Response<LoginResponse>

    @GET("jobs")
    suspend fun getAllJobList(
        @Query("page") page: String,
        @Query("per_page") perPage: String
    ): Response<AllJobListResponse>

    @GET("jobs/{jobID}")
    suspend fun getJobDetailsByID(
        @Path("jobID") jobID: String
    ): Response<Jobs>
    @GET("user/user1")
    suspend fun getUserByID(): Response<Jobs>



}