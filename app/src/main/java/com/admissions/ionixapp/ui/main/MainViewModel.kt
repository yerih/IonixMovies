package com.admissions.ionixapp.ui.main

import androidx.lifecycle.*
import com.admissions.ionixapp.usecases.GetPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val moviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {

    data class UiState(
        val loading: Boolean = false,
        val movies: List<com.admissions.ionixapp.domain.Movie>? = null,
        val requestPermissionLocation: Boolean = true,
        val error: String = ""
    )

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
        }
    }

    fun onUiReady(){
        viewModelScope.launch {
        }
    }

}

