package com.medmapper.v33001.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
/**
 * A data class representing Medicine
 *
 * @property name; the name of the medicine
 * @property strength; the strength of the medicine
 * @property start_date; the date the patient started the medicine
 * @property preciscription_length; how long the patient should take the medicine
 *    
 */
@Entity(tableName = "Medicine")
data class Medicine(
    @PrimaryKey(autoGenerate = true) val medID: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "strength") val strength: String?,
    @ColumnInfo(name = "start_date") val startDate: String?,
    @ColumnInfo(name = "prescription_length") val lengthInDays: Int
    //,@ColumnInfo() val endDate: Date = startDate
)
