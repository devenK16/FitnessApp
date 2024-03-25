package com.example.fitnessapp.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.fitnessapp.R

class TrainBodyPartsAdapter(private val bodyParts: Array<String>) :
    RecyclerView.Adapter<TrainBodyPartsAdapter.BodyPartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BodyPartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.exercise_item_names, parent, false)
        return BodyPartViewHolder(view)
    }

    override fun onBindViewHolder(holder: BodyPartViewHolder, position: Int) {
        holder.bind(bodyParts[position])
    }

    override fun getItemCount(): Int {
        return bodyParts.size
    }

    inner class BodyPartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewBodyPart: TextView = itemView.findViewById(R.id.tv_exerciseNameItem)

        fun bind(bodyPart: String) {
            textViewBodyPart.text = bodyPart
            itemView.setOnClickListener {
                val context = itemView.context
                val intent = Intent(context, ExerciseList::class.java)
                intent.putExtra("fromBodyPart", bodyPart )
                context.startActivity(intent)
            }
        }
    }
}