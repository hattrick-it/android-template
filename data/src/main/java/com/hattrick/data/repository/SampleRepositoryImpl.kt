package com.hattrick.data.repository

import android.util.Log
import com.hattrick.data.model.SampleDataModel
import com.hattrick.data.model.toDomain
import com.hattrick.domain.model.SampleModel
import com.hattrick.domain.repository.SampleRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class SampleRepositoryImpl(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val sampleLocalDataSource: SampleLocalDataSource,
    private val sampleRemoteDataSource: SampleRemoteDataSource,
) : SampleRepository {

    private suspend fun getApiResponse(int: Int): SampleDataModel? {
        return try {
            sampleRemoteDataSource.getApiResponse(int)
        } catch (e: Exception) {
            Timber.e(e)
            null
        }
    }

    override suspend fun sampleFun(int: Int): SampleModel {
        return withContext(ioDispatcher) {
            val dbRes = sampleLocalDataSource.getElementFromDb(int)
            if (dbRes != null) {
                dbRes.toDomain()
            } else {
                val apiRes = getApiResponse(int) ?: throw Exception("Remote error")
                sampleLocalDataSource.saveElementToDb(apiRes)
                apiRes.toDomain()
            }

        }
    }

}