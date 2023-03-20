package com.samad_talukder.seekmaxhomeassignment.domain

import com.samad_talukder.seekmaxhomeassignment.data.repository.home.HomeRepository

/**
 * The use case for all job list for home.
 * @property HomeRepository The repository for making network calls.
 */

class AllJobListUseCase(private val homeRepository: HomeRepository) {
    suspend fun execute(page: Int) =
        homeRepository.getAllJobList(page)
}