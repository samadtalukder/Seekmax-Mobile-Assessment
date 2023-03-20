package com.samad_talukder.seekmaxhomeassignment.data.graphql

import JobsQuery
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Input
import com.apollographql.apollo.api.Response
import com.samad_talukder.seekmaxhomeassignment.api.BaseApiResponse
import javax.inject.Inject

/*
class PublishedJobsRepository @Inject constructor(private val apolloClient: ApolloClient) :
    BaseApiResponse() {

    suspend fun getPublishedJob(page: Int): Response<JobsQuery.Data> {
        return graphQueryCall { apolloClient.query(JobsQuery(Input.optional(page))) }
    }
}*/
