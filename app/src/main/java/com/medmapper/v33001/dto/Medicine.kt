package com.medmapper.v33001.dto

import java.time.LocalDate

data class Medicine(
    var id: String = "",
    var uid: String = "",
    var name: String = "",
    var quantity: Int = 0,
    var prescriptionStrength: String = "",
    var startDate: LocalDate = LocalDate.now(),
    var prescriptionLength: String = "",
    var time: Long = 0,
    // Frequency per 24 hours
    var frequency: Int = 0) {
    override fun toString(): String {
        return "$name, $quantity , $prescriptionStrength"
    }

    // Need to properly create function or service to translate string to dates, etc.
    /*fun getEndDate(): String {
        var endDate = startDate + prescriptionLength
        return endDate
    }*/
}