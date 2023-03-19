package com.samad_talukder.seekmaxhomeassignment.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Samad Talukder on 18 March 2023.
 * github.com/samadtalukder
 **/

data class AllJobListResponse(
    val hasNext: Boolean,
    val jobs: List<Jobs>,
    val page: Int,
    val size: Int,
    val total: Int
)

data class Company(
    @SerializedName("_id")
    val id: String,
    val createdAt: String,
    val name: String,
    val updatedAt: String
)

data class Jobs(
    @SerializedName("__v")
    val v: Int,
    @SerializedName("_id")
    val id: String,
    val company: Company,
    val createdAt: String,
    val description: String,
    val haveIApplied: Boolean,
    val industry: Int,
    val location: Int,
    val positionTitle: String,
    val salaryRange: SalaryRange,
    val status: Int,
    val updatedAt: String
)

data class SalaryRange(
    val max: Int,
    val min: Int
)
