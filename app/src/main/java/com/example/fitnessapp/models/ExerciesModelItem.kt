package com.example.fitnessapp.models


import androidx.annotation.Keep

@Keep
data class ExerciesModelItem(
    val bodyPart: String,
    val equipment: String,
    val gifUrl: String,
    val id: String,
    val instructions: List<String>,
    val name: String,
    val secondaryMuscles: List<String>,
    val target: String
)