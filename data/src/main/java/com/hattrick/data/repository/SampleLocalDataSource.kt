package com.hattrick.data.repository

import com.hattrick.data.model.SampleDataModel

interface SampleLocalDataSource {
    suspend fun saveElementToDb(sampleDataModel: SampleDataModel)
    suspend fun clearDb()
    suspend fun deleteElementFromDb(int: Int)
    suspend fun getAllFromDb(): List<SampleDataModel>
    suspend fun getElementFromDb(int: Int): SampleDataModel?
}