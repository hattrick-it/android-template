package com.hattrick.data.repository

import android.util.Log
import com.hattrick.data.model.SampleDataModel
import com.hattrick.data.model.toDomain
import com.hattrick.domain.model.SampleModel
import com.hattrick.domain.repository.SampleRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SampleRepositoryImpl(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val sampleLocalDataSource: SampleLocalDataSource,
    private val sampleRemoteDataSource: SampleRemoteDataSource,
) : SampleRepository {

    private suspend fun getApiResponse(int: Int): SampleModel? {
        return try {
            sampleRemoteDataSource.getApiResponse(int).toDomain()
        } catch (e: Exception) {
            Log.e("Error: ", e.toString())
            null
        }
    }

    override suspend fun sampleFun(int: Int): SampleModel = withContext(ioDispatcher) {
        if (sampleLocalDataSource.getElementFromDb(int) != null) {
            sampleLocalDataSource.getElementFromDb(int).toDomain()
        } else {
            sampleLocalDataSource.saveElementToDb(sampleRemoteDataSource.getApiResponse(int))
            getApiResponse(int)!!
        }
    }

}