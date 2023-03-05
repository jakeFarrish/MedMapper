package com.medmapper.v33001.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.medmapper.v33001.dao.DateConverter

@Entity(tableName = "Medicine")
@TypeConverters(DateConverter::class)
data class Medicine(
    @PrimaryKey(autoGenerate = true) val medID: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "strength") val strength: String?,
    @ColumnInfo(name = "start_date") val startDate: String?,
    @ColumnInfo(name = "prescription length") val lengthInDays: Int
    //,@ColumnInfo() val endDate: Date = startDate
)