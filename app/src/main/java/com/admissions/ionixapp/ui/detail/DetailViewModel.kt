package com.admissions.ionixapp.ui.detail

import androidx.lifecycle.*
import com.admissions.ionixapp.domain.Movie
import com.admissions.ionixapp.usecases.GetPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val moviesUseCase: GetPopularMoviesUseCase,
) : ViewModel() {

//    private val artistId = DetailFragmentArgs.fromSavedStateHandle(savedStateHandle).artistId

    data class UiState(val movie: Movie? = null, val error: Error? = null)
    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
        }
    }

    fun onFavoriteClicked() {
        viewModelScope.launch {
        }
    }

}



