package com.medmapper.v33001.dto

data class Medicine(
    var medicationID: String = "",
    var name: String = "",
    var quantity: String = "",
    var prescriptionStrength: String = "",
    var startDate: String = "",
    var prescriptionLength: String = "",
    var takeTime: Double = 0.0) {
    override fun toString(): String {
        return "$name, $quantity , $prescriptionStrength"
    }

    // Need to properly create function or service to translate string to dates, etc.
    /*fun getEndDate(): String {
        var endDate = startDate + prescriptionLength
        return endDate
    }*/
}