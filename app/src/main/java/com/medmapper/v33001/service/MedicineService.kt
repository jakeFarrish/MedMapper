package com.medmapper.v33001.service

import com.medmapper.v33001.dto.Medicine

interface IMedicineService {
    suspend fun fetchMedicine() : List<Medicine>?
}


class MedicineService: IMedicineService {
    override suspend fun fetchMedicine(): List<Medicine>? {
        TODO("Not yet implemented")
    }
}