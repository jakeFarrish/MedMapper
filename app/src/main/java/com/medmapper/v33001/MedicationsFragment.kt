package com.medmapper.v33001

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MedicationsFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.medications_fragment, container, false)
        recyclerView = view.findViewById(R.id.medications)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = MedRecyclerAdapter(inflater, ArrayList())
        return view
    }
}