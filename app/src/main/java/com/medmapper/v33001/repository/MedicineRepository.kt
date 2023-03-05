package com.medmapper.v33001.repository

import androidx.annotation.WorkerThread
import com.medmapper.v33001.dao.MedicineDAO
import com.medmapper.v33001.dto.Medicine
import kotlinx.coroutines.flow.Flow

// Declares teh DAO as private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class MedicineRepository(private val medicineDAO: MedicineDAO) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.

    val allMedicine: Flow<List<Medicine>> = medicineDAO.getAlphabetizedMedicine()

    fun getMedicineList(): Flow<List<Medicine>> {
        return medicineDAO.getAlphabetizedMedicine()
    }

    suspend fun insert(medicine: Medicine) {
        medicineDAO.insert(medicine)
    }

    suspend fun delete(medicine: Medicine) {
        medicineDAO.delete(medicine)
    }

    suspend fun update(medicine: Medicine) {
        medicineDAO.update(medicine)
    }

}
