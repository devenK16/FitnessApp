package com.example.fitnessapp.api

import com.example.fitnessapp.models.ExerciesModelItem
import com.example.fitnessapp.models.exerciesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BodyPartExerciseAPI {
    @GET("bodyPart/{muscle}")
    suspend fun getBodyPart(@Path("muscle") muscle: String) : Response<exerciesModel>
}