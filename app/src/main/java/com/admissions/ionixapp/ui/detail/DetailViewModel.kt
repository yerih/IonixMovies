package com.admissions.ionixapp.ui.detail

import androidx.lifecycle.*
import com.admissions.ionixapp.common.launch
import com.admissions.ionixapp.common.log
import com.admissions.ionixapp.domain.Movie
import com.admissions.ionixapp.usecases.MoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val moviesUseCase: MoviesUseCase,
) : ViewModel() {

    private val movieId = DetailFragmentArgs.fromSavedStateHandle(savedStateHandle).movieId

    data class UiState(val movie: Movie? = null, val error: String = "")
    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    init {
        launch(Dispatchers.IO) {
            val movie = moviesUseCase.getMovieById(movieId)
            _state.update { it.copy(movie = movie) }
        }
    }

}



