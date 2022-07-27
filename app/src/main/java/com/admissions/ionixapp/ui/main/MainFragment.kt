package com.admissions.ionixapp.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.admissions.ionixapp.R
import com.admissions.ionixapp.common.buildMainState
import com.admissions.ionixapp.databinding.FragmentMainBinding
import com.admissions.ionixapp.common.launchAndCollect
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModels()
    private val adapter = MoviesAdapter{ mainState.onMovieClicked(it) }
    private lateinit var mainState: MainState

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMainBinding.bind(view).apply { recycler.adapter = adapter }
        mainState = buildMainState()
        viewLifecycleOwner.launchAndCollect(viewModel.state){
        }
        mainState.requestLocationPermission { viewModel.onUiReady() }
    }

}