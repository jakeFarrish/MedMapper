package com.medmapper.v33001.dao

import androidx.room.*
import com.medmapper.v33001.dto.Medicine
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicineDAO {

    // Query SQL for the Room Database
    @Query("SELECT * FROM Medicine ORDER BY name ASC")
    fun getAlphabetizedMedicine(): Flow<List<Medicine>>

    // Insert SQL for the Room Database
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(medicine: Medicine)

    // Delete SQL for the Room Database
    @Query("DELETE medicine FROM Medicine")
    suspend fun delete()
}