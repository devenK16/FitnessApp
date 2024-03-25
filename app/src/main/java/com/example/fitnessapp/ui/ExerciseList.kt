package com.example.fitnessapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.fitnessapp.R
import com.example.fitnessapp.databinding.ActivityExerciseListBinding
import com.example.fitnessapp.models.exerciesModel
import com.example.fitnessapp.util.NetworkResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExerciseList : AppCompatActivity() {
    private var _binding : ActivityExerciseListBinding ?= null
    private val binding get() = _binding!!
    private lateinit var exercises: exerciesModel
    private lateinit var bodyPartViewModel: BodyPartViewModel
    private lateinit var targetViewModel: TargetViewModel
    private lateinit var adapter: ExerciseListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityExerciseListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bodyPartViewModel = ViewModelProvider(this).get(BodyPartViewModel::class.java)
        targetViewModel = ViewModelProvider(this).get(TargetViewModel::class.java)

        bindObserversBody()
        bindObserversTarget()

        val recyclerView: RecyclerView = binding.rvExerciseItem
        recyclerView.layoutManager = StaggeredGridLayoutManager(
            2,
            StaggeredGridLayoutManager.VERTICAL
        )

        adapter = ExerciseListAdapter()
        recyclerView.adapter = adapter

        var bodyPartExercise: String ?= null
        var targetExercise: String ?= null

        bodyPartExercise = intent.getStringExtra("fromBodyPart")
        targetExercise = intent.getStringExtra("fromTargetMuscle")

        if( bodyPartExercise != null ){
            bindObserversBody()
            bodyPartViewModel.getBodyPartExercise(bodyPartExercise)
        }
        else{
            if (targetExercise != null) {
                bindObserversTarget()
                targetViewModel.getTargetExercise(targetExercise)
            }
        }
    }

    private fun bindObserversBody() {
        bodyPartViewModel.bodyPartResponseLiveData.observe(this, Observer { result ->
            when (result) {
                is NetworkResult.Success -> {
                    adapter.submitList(result.data)
                }
                is NetworkResult.Error -> {
                    Toast.makeText(this, result.message.toString(), Toast.LENGTH_SHORT).show()
                }
                is NetworkResult.Loading -> {
                    // Show progress bar or loading indicator
                }
            }
        })
    }

    private fun bindObserversTarget() {
        targetViewModel.targetResponseLiveData.observe(this, Observer { result ->
            when (result) {
                is NetworkResult.Success -> {
                    adapter.submitList(result.data)
                }
                is NetworkResult.Error -> {
                    Toast.makeText(this, result.message.toString(), Toast.LENGTH_SHORT).show()
                }
                is NetworkResult.Loading -> {
                    // Show progress bar or loading indicator
                }
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}