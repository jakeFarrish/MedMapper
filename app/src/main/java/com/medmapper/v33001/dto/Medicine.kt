package com.medmapper.v33001.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Medicine")
data class Medicine(
    @PrimaryKey(autoGenerate = true) var medID: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "strength") val strength: String?,
    @ColumnInfo(name = "start date") val startDate: String?,
    @ColumnInfo(name = "prescription length") val lengthInDays: Int?,
    @ColumnInfo(name = "frequency") val frequency: String?,
    @ColumnInfo(name = "reason") val reason: String?
    //,@ColumnInfo() val endDate: Date = startDate
)