package com.medmapper.v33001.dto

import java.time.LocalDate

data class Medicine(
    val id: String = "",
    val uid: String = "",
    val name: String = "",
    val quantity: Int = 0,
    val prescriptionStrength: String = "",
    val startDate: LocalDate = LocalDate.now(),
    val prescriptionLength: String = "",
    val time: Long = 0,
    // Frequency per 24 hours
    val frequency: Int = 0) {
    override fun toString(): String {
        return "$name, $quantity , $prescriptionStrength"
    }

    // Need to properly create function or service to translate string to dates, etc.
    /*fun getEndDate(): String {
        var endDate = startDate + prescriptionLength
        return endDate
    }*/
}