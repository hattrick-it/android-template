package com.hattrick.data.repository

import com.hattrick.data.model.SampleDataModel

interface SampleRemoteDataSource {
    suspend fun getApiResponse(int: Int): SampleDataModel
}