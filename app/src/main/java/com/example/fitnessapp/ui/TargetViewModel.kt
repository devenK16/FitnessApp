package com.example.fitnessapp.ui

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.models.exerciesModel
import com.example.fitnessapp.repository.TargetRepository
import com.example.fitnessapp.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TargetViewModel @Inject constructor( private val targetRepository: TargetRepository ) : ViewModel() {
    val targetResponseLiveData : LiveData<NetworkResult<exerciesModel>>
        get() = targetRepository.targetMuscleLiveData
    fun getTargetExercise( muscle : String ){
        viewModelScope.launch {
            targetRepository.getTargetExercise(muscle)
        }
    }
}
