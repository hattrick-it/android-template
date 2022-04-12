package com.hattrick.myapplication.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel() : ViewModel() {

    //region Outputs
    val isLoading: LiveData<Boolean>
        get() = _isLoading
    val error: LiveData<Int>
        get() = _error
    //endregion

    //region Properties
    protected val _isLoading = MutableLiveData<Boolean>()
    protected val _error = MutableLiveData<Int>()
}