package com.example.fitnessapp.repository

import android.util.Log
import com.example.fitnessapp.api.BodyPartExerciseAPI
import javax.inject.Inject

class BodyPartRepository @Inject constructor( private val bodyPartExerciseAPI: BodyPartExerciseAPI ) {

    suspend fun getBodyPartExercise( bodyPart : String ){
        val response = bodyPartExerciseAPI.getBodyPart( bodyPart)
        Log.d("repoBodyPart" , response.body().toString())
    }
}