package com.admissions.ionixapp.ui.main

import android.Manifest
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.admissions.ionixapp.R
import com.admissions.ionixapp.domain.Movie
import com.admissions.ionixapp.ui.common.PermissionRequester
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainState(
    private val context: Context,
    private val scope: CoroutineScope,
    private val navController: NavController,
    private val locationPermissionRequest: PermissionRequester
) {


    fun onMovieClicked(movie: Movie){
        val action = MainFragmentDirections.actionMainDestToDetailDest(movie.id)
        navController.navigate(action)
    }

    fun requestLocationPermission(onRequestDone: (Boolean) -> Unit){
        scope.launch { onRequestDone(locationPermissionRequest.request()) }
    }

}