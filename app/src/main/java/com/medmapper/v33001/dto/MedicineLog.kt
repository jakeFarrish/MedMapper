package com.medmapper.v33001.dto
import com.medmapper.v33001.dto.Medicine
import com.medmapper.v33001.dto.User
import java.time.LocalDateTime

//Log for medication adherence

data class MedicineLog (
    val id: String = "",
    val medicationId: String = "",
    val uid: String = "",
    val time: LocalDateTime = LocalDateTime.now()
)
