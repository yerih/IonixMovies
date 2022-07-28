package com.admissions.ionixapp.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.admissions.ionixapp.R
import com.admissions.ionixapp.databinding.FragmentDetailBinding
import com.admissions.ionixapp.common.launchAndCollect
import com.admissions.ionixapp.common.log
import com.admissions.ionixapp.common.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment: Fragment(R.layout.fragment_detail) {

    private val safeArgs: DetailFragmentArgs by navArgs()
    private val viewModel: DetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDetailBinding.bind(view)
        binding.movieDetailToolbar.setNavigationOnClickListener { requireActivity().onBackPressed() }
        launchAndCollect(viewModel.state){ state ->
            binding.movie = state.movie
            if(state.error.isNotEmpty())toast(state.error)
        }
    }

}