package com.medmapper.v33001.dao

import androidx.room.*
import com.medmapper.v33001.dto.Medicine
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicineDAO {
    @Query("SELECT * FROM Medicine ORDER BY name ASC")
    fun getAllAlphabetizedMedicine(): Flow<List<Medicine>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(medicine: Medicine)

    @Query("DELETE FROM Medicine")
    suspend fun deleteAll()
}