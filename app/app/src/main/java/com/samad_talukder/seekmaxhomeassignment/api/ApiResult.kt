package com.samad_talukder.seekmaxhomeassignment.api

/**
 * Created by Samad Talukder on 18 March 2023.
 * github.com/samadtalukder
 **/


sealed class ApiResult<out T> {
    object Loading : ApiResult<Nothing>()

    data class Success<out T>(
        val data: T
    ) : ApiResult<T>()

    data class Error(
        val errorMessage: String,
        val code: Int,
    ) : ApiResult<Nothing>()
}