package com.example.fitnessapp.api

import com.example.fitnessapp.models.ExerciesModelItem
import com.example.fitnessapp.models.exerciesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TargetExerciseAPI {
    @GET("target/{muscle}")
    suspend fun getTargetPart(@Path("muscle") muscle: String) : Response<exerciesModel>
}