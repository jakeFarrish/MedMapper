package com.medmapper.v33001.dto

import java.time.Duration
import java.time.LocalDate
import java.util.concurrent.TimeUnit

data class Medicine(
    val id: String = "",
    val uid: String = "",
    val name: String = "",
    val quantity: Int = 0,
    val prescriptionStrength: String = "",
    val startDate: LocalDate = LocalDate.now(),
    val prescriptionLength: Duration = Duration.ZERO,
    val timeUnit: TimeUnit = TimeUnit.HOURS,
    val frequency: Int = 0) {
    override fun toString(): String {
        return "$name, $quantity , $prescriptionStrength"
    }

    fun getEndDate(): LocalDate {
        return startDate.plus(prescriptionLength)
    }
}


// Need to properly create function or service to translate string to dates, etc.
/*fun getEndDate(): String {
    var endDate = startDate + prescriptionLength
    return endDate
}*/