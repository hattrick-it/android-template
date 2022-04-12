package com.hattrick.myapplication.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hattrick.domain.resource.CustomError

open class BaseViewModel() : ViewModel() {

    //region Outputs
    val isLoading: LiveData<Boolean>
        get() = _isLoading
    val error: LiveData<CustomError>
        get() = _error
    //endregion

    //region Properties
    protected val _isLoading = MutableLiveData<Boolean>()
    protected val _error = MutableLiveData<CustomError>()
}