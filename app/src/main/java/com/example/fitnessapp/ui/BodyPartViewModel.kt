package com.example.fitnessapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.models.exerciesModel
import com.example.fitnessapp.repository.BodyPartRepository
import com.example.fitnessapp.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BodyPartViewModel @Inject constructor(private val bodyPartRepository: BodyPartRepository ) : ViewModel() {
    val bodyPartResponseLiveData : LiveData<NetworkResult<exerciesModel>>
        get() = bodyPartRepository.bodyPartLiveData
    fun getBodyPartExercise(bodyPart : String ){
        viewModelScope.launch{
            bodyPartRepository.getBodyPartExercise(bodyPart)
        }
    }
}