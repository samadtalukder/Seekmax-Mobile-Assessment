package com.samad_talukder.seekmaxhomeassignment.domain

import com.samad_talukder.seekmaxhomeassignment.data.repository.home.HomeRepository

/**
 * The use case for get job details by id.
 * @property HomeRepository The repository for making network calls.
 */

class JobDetailsByIDUseCase(private val homeRepository: HomeRepository) {
    suspend fun execute(jobID: String) = homeRepository.getJobDetailsByID(jobID)
}