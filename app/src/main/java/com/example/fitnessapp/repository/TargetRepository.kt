package com.example.fitnessapp.repository

import android.util.Log
import com.example.fitnessapp.api.TargetExerciseAPI
import javax.inject.Inject

class TargetRepository @Inject constructor( private val targetExerciseAPI: TargetExerciseAPI ) {

    suspend fun getTargetExercise( muscle : String ){
        val response = targetExerciseAPI.getTargetPart(muscle)
        Log.d("repoTarget" , response.body().toString())
    }
}