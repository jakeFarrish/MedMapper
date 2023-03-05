package com.medmapper.v33001

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.medmapper.v33001.dto.Medicine

class MedRecyclerAdapter(private val inflater: LayoutInflater, var meds: ArrayList<Medicine>): RecyclerView.Adapter<MedRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.medication_line_item, parent, false))
    }

    override fun getItemCount(): Int {
        return meds.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = meds[position].name
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.medication_name)
    }
}