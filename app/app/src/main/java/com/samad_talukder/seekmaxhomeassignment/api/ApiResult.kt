package com.samad_talukder.seekmaxhomeassignment.api

/**
 * A sealed class representing the result of an API call.
 * The result can be in one of three states:
 * Loading: The API call is currently in progress
 * Success: The API call completed successfully and returned a data object
 * Error: The API call failed with an error message and an HTTP error code
 * @param T The type of data returned on successful API calls
 */

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