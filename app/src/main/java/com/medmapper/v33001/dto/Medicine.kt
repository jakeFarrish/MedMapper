package com.medmapper.v33001.dto

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Medicine")
data class Medicine(
    @PrimaryKey(autoGenerate = true) val medID: Int,
    @NonNull @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "strength") val strength: String?,
    @NonNull @ColumnInfo(name = "start date") val startDate: String,
    @NonNull @ColumnInfo(name = "prescription length") val lengthInDays: Int
    //,@ColumnInfo() val endDate: Date = startDate
)