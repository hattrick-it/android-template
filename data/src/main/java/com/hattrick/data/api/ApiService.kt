package com.hattrick.data.api

import com.hattrick.data.model.SampleDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("url")
    suspend fun getApiResponse(
        @Query("queryInt") queryInt: Int,
    ): Response<SampleDataModel>
}