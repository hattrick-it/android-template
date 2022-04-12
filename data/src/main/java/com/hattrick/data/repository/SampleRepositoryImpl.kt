package com.hattrick.data.repository

import com.hattrick.domain.model.SampleModel
import com.hattrick.domain.repository.SampleRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SampleRepositoryImpl(private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO) :
    SampleRepository {

    override suspend fun sampleFun(): SampleModel = withContext(ioDispatcher) {
        SampleModel("name")
    }

}