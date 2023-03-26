package com.medmapper.v33001.dto

//Information to be included in the phone alerts for medication
//time = time to take medication

data class MedicineAlert (
    val id: String,
    val name: String,
    val time: Long
)