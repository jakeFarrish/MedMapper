package com.medmapper.v33001.repository

import androidx.annotation.WorkerThread
import com.medmapper.v33001.dao.MedicineDAO
import com.medmapper.v33001.dto.Medicine
import kotlinx.coroutines.flow.Flow

/**
 * Declares the DAO as private property in the constructor.
 * Pass in the DAO instead of the whole database, because you only need access to the DAO
 */
class MedicineRepository(private val medicineDAO: MedicineDAO) {

     // Room executes all queries on a separate thread.
     // Observed Flow will notify the observer when the data has changed.

    val allMedicines: Flow<List<Medicine>> = medicineDAO.getAllAlphabetizedMedicine()

     // By default Room runs suspend queries off the main thread, therefore
     // we don't need to implement anything else to ensure we're not doing
     // long running database work off the main thread

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(medicine: Medicine) {
        medicineDAO.insert(medicine)
    }
}