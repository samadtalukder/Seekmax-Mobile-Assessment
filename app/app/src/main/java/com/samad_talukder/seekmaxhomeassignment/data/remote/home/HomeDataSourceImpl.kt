package com.samad_talukder.seekmaxhomeassignment.data.remote.home

import com.samad_talukder.seekmaxhomeassignment.api.SeeksMaxApi
import com.samad_talukder.seekmaxhomeassignment.domain.model.AllJobListResponse
import com.samad_talukder.seekmaxhomeassignment.domain.model.Jobs
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Samad Talukder on 18 March 2023.
 * github.com/samadtalukder
 **/

class HomeDataSourceImpl @Inject constructor(private var seeksMaxApi: SeeksMaxApi) :
    HomeDataSource {

    override suspend fun getAllJobList(
        page: String,
        perPage: String
    ): Response<AllJobListResponse> {
        return seeksMaxApi.getAllJobList(page, perPage)
    }

    override suspend fun getJobDetailsByID(jobID: String): Response<Jobs> {
        return seeksMaxApi.getJobDetailsByID(jobID)
    }

    override suspend fun getUserByID(): Response<Jobs> {
        return seeksMaxApi.getUserByID()
    }


}