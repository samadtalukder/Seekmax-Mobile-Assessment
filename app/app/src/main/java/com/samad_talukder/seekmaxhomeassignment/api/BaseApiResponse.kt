package com.samad_talukder.seekmaxhomeassignment.api


import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.coroutines.await
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

    suspend fun <T : Any> graphQueryCall(call: () -> ApolloCall<T>): com.apollographql.apollo.api.Response<T> {
        val graphCall: ApolloCall<T> = call()
        return try {
            graphCall.await()
        } catch (t: Throwable) {
            val operation = graphCall.operation()

            com.apollographql.apollo.api.Response.builder<T>(operation)
                .errors(listOf(com.apollographql.apollo.api.Error(t.message ?: "Error"))).build()
        }
    }

}