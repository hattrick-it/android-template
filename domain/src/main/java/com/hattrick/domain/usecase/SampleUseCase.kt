package com.hattrick.domain.usecase

import com.hattrick.domain.model.SampleModel
import com.hattrick.domain.repository.SampleRepository
import com.hattrick.domain.resource.CustomError
import com.hattrick.domain.resource.Resource

interface SampleUseCase {

    suspend fun sampleUseCaseFun(int: Int): Resource<SampleModel>

}

class SampleUseCaseImpl(private val sampleRepository: SampleRepository) : SampleUseCase {

    override suspend fun sampleUseCaseFun(int: Int): Resource<SampleModel> {
        return try {
            Resource.Success(sampleRepository.sampleFun(int))
        } catch (e: Exception) {
            Resource.Error(CustomError.SAMPLE_ERROR)
        }
    }

}