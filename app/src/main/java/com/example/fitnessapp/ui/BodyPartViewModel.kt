package com.example.fitnessapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.repository.BodyPartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BodyPartViewModel @Inject constructor(private val bodyPartRepository: BodyPartRepository ) : ViewModel() {

    fun getBodyPartExercise(bodyPart : String ){
        viewModelScope.launch{
            bodyPartRepository.getBodyPartExercise(bodyPart)
        }
    }
}