package com.hattrick.myapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hattrick.myapplication.presentation.state.ScreenTwoState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import timber.log.Timber

class ScreenTwoViewModel : ViewModel() {

    private val screenTwoViewModelState = MutableStateFlow(ScreenTwoState(isLoading = true))

    val uiState = screenTwoViewModelState
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            screenTwoViewModelState.value
        )

    fun toggleButton() {
        screenTwoViewModelState.update {
            it.copy(isChecked = !it.isChecked)
        }
        Timber.d(screenTwoViewModelState.value.isChecked.toString())
    }
}