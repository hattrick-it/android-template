package com.hattrick.myapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hattrick.domain.model.SampleModel
import com.hattrick.domain.usecase.SampleUseCase
import com.hattrick.myapplication.presentation.base.BaseViewModel
import kotlinx.coroutines.launch

class SampleViewModel(private val sampleUseCase: SampleUseCase) : BaseViewModel() {

    val _sampleOutput = MutableLiveData<SampleModel>()
    val sampleOutput: LiveData<SampleModel>
        get() = _sampleOutput

    fun sampleViewModelFun(int: Int) {
        _isLoading.postValue(true)
        viewModelScope.launch {
            sampleUseCase.sampleUseCaseFun(int).checkResult(
                onSuccess = { _sampleOutput.postValue(it) },
                onError = { _error.postValue(it) }
            )
        }
    }

}