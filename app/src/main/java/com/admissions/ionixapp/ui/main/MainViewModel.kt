package com.admissions.ionixapp.ui.main

import androidx.lifecycle.*
import com.admissions.ionixapp.common.launch
import com.admissions.ionixapp.domain.Movie
import com.admissions.ionixapp.usecases.MoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val moviesUseCase: MoviesUseCase
) : ViewModel() {

    data class UiState(
        val loading: Boolean = false,
        val list: List<Movie> = mutableListOf(),
        val requestPermissionLocation: Boolean = true,
        val error: String = ""
    )
    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    init {
        launch(Dispatchers.IO) {
            val result = moviesUseCase.getPopularMovies()
            if(result.isError){
                _state.update { it.copy(error = result.error.toString()) }
                return@launch
            }
            val list = result.result!!.toMutableList()
            _state.update { UiState(list = list) }
        }

    }

    fun onUiReady(){}

}

