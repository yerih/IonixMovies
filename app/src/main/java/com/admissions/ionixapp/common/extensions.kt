package com.admissions.ionixapp.common

import android.Manifest
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DiffUtil
import com.admissions.ionixapp.IonixApp
import com.admissions.ionixapp.R
import com.admissions.ionixapp.ui.common.PermissionRequester
import com.admissions.ionixapp.ui.main.MainState
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch




fun Any.log( value: String = "value?", label: String = "TGB") = Log.i(label, value)

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = true): View =
    LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)

@BindingAdapter("loadUrl")
fun ImageView.loadUrl(url: String?){
    url?.let { Glide.with(context).load(url).into(this) }
}

inline fun <T> basicDiffUtil(
    crossinline areItemsTheSame: (T, T) -> Boolean = { old, new -> old == new },
    crossinline areContentsTheSame: (T, T) -> Boolean = { old, new -> old == new }
) = object : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean =
        areItemsTheSame(oldItem, newItem)

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean =
        areContentsTheSame(oldItem, newItem)
}

var View.visible: Boolean get() { return visibility == View.VISIBLE }
    set(value) { visibility = if(value) View.VISIBLE else View.GONE}


fun <T> LifecycleOwner.launchAndCollect(
    flow: Flow<T>,
    state: Lifecycle.State = Lifecycle.State.STARTED,
    body: (T) -> Unit
){
    lifecycleScope.launch {
        this@launchAndCollect.repeatOnLifecycle(state){
            flow.collect(body)
        }
    }
}

val Context.app: IonixApp get() = applicationContext as IonixApp


fun Fragment.buildMainState(
    scope: CoroutineScope = lifecycleScope,
    navController: NavController = findNavController(),
    locationPermissionRequester: PermissionRequester = PermissionRequester(
        this,
        Manifest.permission.ACCESS_COARSE_LOCATION
    )
) = MainState(requireContext(), scope, navController, locationPermissionRequester)

fun ViewModel.launch(dispatcher: CoroutineDispatcher = Dispatchers.Main, launch: suspend () -> Unit){ viewModelScope.launch(dispatcher){launch()} }




