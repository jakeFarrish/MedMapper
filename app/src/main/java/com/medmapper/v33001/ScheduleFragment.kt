package com.medmapper.v33001

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class ScheduleFragment: Fragment() {
    lateinit var email: EditText
    lateinit var schedule: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.schedule_fragment, container, false)
        schedule = view.findViewById(R.id.schedule)
        email = view.findViewById(R.id.editTextTextEmailAddress)
        return view
    }
}