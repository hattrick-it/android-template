package com.hattrick.data.repository

import com.hattrick.data.api.ApiService
import com.hattrick.data.model.SampleDataModel

class SampleRemoteDataSourceImpl(private val apiService: ApiService): SampleRemoteDataSource {
    override suspend fun getApiResponse(int: Int): SampleDataModel {
        val res = apiService.getApiResponse(int)
        return if (res.isSuccessful) {
            res.body() ?: throw Exception("Empty value")
        } else {
            throw Exception("Retrofit error")
        }
    }
}