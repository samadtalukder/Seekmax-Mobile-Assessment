package com.samad_talukder.seekmaxhomeassignment.domain

import com.samad_talukder.seekmaxhomeassignment.data.repository.home.HomeRepository

/**
 * Created by Samad Talukder on 18 March 2023.
 * github.com/samadtalukder
 **/

class AllJobListUseCase(private val homeRepository: HomeRepository) {
    suspend fun execute(page: String, perPage: String) =
        homeRepository.getAllJobList(page, perPage)
}