package com.samad_talukder.seekmaxhomeassignment.api


import retrofit2.Response

/**
 * A base class for handling API responses.
 */

abstract class BaseApiResponse {

    suspend fun <T : Any> safeApiCall(
        apiCall: suspend () -> Response<T>,
    ): ApiResult<T> {
        val response: Response<T>

        try {
            response = apiCall.invoke()
        } catch (t: Throwable) {
            return ApiResult.Error(t.message ?: t.toString(), 400)
        }

        try {
            if (response.isSuccessful) {
                response.body()?.let { data ->
                    return ApiResult.Success(data)
                }
            } else {
                response.errorBody()?.let { error ->
                    error.close()
                    return ApiResult.Error(error.string(), response.code())
                }
            }
        } catch (e: Exception) {
            return ApiResult.Error(e.message ?: e.toString(), 400)
        }
        return ApiResult.Error("Unknown Error", 400)
    }

}