package com.example.fitnessapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessapp.R

class TrainTargetMuscleAdapter(private val targetMuscles: Array<String>) :
    RecyclerView.Adapter<TrainTargetMuscleAdapter.TargetMuscleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TargetMuscleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.exercise_item_names, parent, false)
        return TargetMuscleViewHolder(view)
    }

    override fun onBindViewHolder(holder: TargetMuscleViewHolder, position: Int) {
        holder.bind(targetMuscles[position])
    }

    override fun getItemCount(): Int {
        return targetMuscles.size
    }

    inner class TargetMuscleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewTargetMuscle: TextView = itemView.findViewById(R.id.tv_exerciseNameItem)

        fun bind(targetMuscle: String) {
            textViewTargetMuscle.text = targetMuscle
        }
    }
}