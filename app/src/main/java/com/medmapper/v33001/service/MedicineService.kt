package com.medmapper.v33001.service

import com.medmapper.v33001.dto.Medicine

interface IMedicineService {
    suspend fun fetchMedicine() : List<Medicine>?
}

// TBD code here
/*class MedicineService: IMedicineService {

}*/