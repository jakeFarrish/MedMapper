package com.medmapper.v33001.service

import com.medmapper.v33001.RetrofitClientInstance
import com.medmapper.v33001.dao.MedicineDAO
import com.medmapper.v33001.dto.Medicine
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

interface IMedicineService{
    suspend fun fetchMedicines() : List<Medicine>?
}
abstract class MedicineService: IMedicineService {
    suspend fun fetcMedicines() : List<Medicine>? {
        return withContext(Dispatchers.IO) {
            val service = RetrofitClientInstance.retrofitInstance?.create(MedicineDAO::class.java)
            val medicines = async {service?.getAllMedicines()}
            var result = medicines.await()?.awaitResponse()?.body()
            return@withContext result
        }
    }
}