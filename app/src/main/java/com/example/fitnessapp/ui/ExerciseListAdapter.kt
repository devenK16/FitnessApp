package com.example.fitnessapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.fitnessapp.R
import com.example.fitnessapp.models.ExerciesModelItem
import com.example.fitnessapp.models.exerciesModel
import pl.droidsonroids.gif.GifImageView

class ExerciseListAdapter : ListAdapter<ExerciesModelItem, ExerciseListAdapter.ExerciseListViewHolder>(ExerciseDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.exercise_item, parent, false)
        return ExerciseListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExerciseListViewHolder, position: Int) {
        val exercise = getItem(position)
        holder.bind(exercise)
    }

    inner class ExerciseListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewBodyPart: TextView = itemView.findViewById(R.id.tvExerciseItem)
        private val gifImageView: GifImageView = itemView.findViewById(R.id.ivExerciseItem)

        fun bind(exerciseModelItem: ExerciesModelItem) {
            Glide.with(itemView)
                .asGif()
                .load(exerciseModelItem.gifUrl)
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.RESOURCE))
                .into(gifImageView)
            textViewBodyPart.text = exerciseModelItem.name
        }
    }

    class ExerciseDiffCallback : DiffUtil.ItemCallback<ExerciesModelItem>() {
        override fun areItemsTheSame(oldItem: ExerciesModelItem, newItem: ExerciesModelItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ExerciesModelItem, newItem: ExerciesModelItem): Boolean {
            return oldItem == newItem
        }
    }
}