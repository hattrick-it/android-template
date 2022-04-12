package com.hattrick.domain.repository

import com.hattrick.domain.model.SampleModel

interface SampleRepository {

    suspend fun sampleFun(): SampleModel

}