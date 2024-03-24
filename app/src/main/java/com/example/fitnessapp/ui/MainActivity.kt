package com.example.fitnessapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fitnessapp.R
import com.example.fitnessapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding ?= null
    private val binding get() = _binding!!
    private lateinit var bodyPartViewModel : BodyPartViewModel
    private lateinit var targetViewModel: TargetViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bodyPartViewModel = ViewModelProvider(this).get(BodyPartViewModel::class.java)
        targetViewModel = ViewModelProvider(this).get(TargetViewModel::class.java)

        val response = bodyPartViewModel.getBodyPartExercise("back")
        val response2 = targetViewModel.getTargetExercise("biceps")

        Log.d("BodyPartResponse" , response.toString())
        Log.d("TargetResponse" , response2.toString())

    }
}