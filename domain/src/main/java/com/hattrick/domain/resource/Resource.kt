package com.hattrick.domain.resource

sealed class Resource<out T> {

    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val error: CustomError) : Resource<Nothing>()

    suspend fun checkResult(
        onSuccess: suspend (T) -> Unit,
        onError: suspend (CustomError) -> Unit
    ) {
        when (this) {
            is Success -> {
                onSuccess(data)
            }
            is Error -> {
                onError(error)
            }
        }
    }

}
