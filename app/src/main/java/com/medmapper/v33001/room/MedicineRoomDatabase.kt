package com.medmapper.v33001.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.medmapper.v33001.dao.MedicineDAO
import com.medmapper.v33001.dto.Medicine

@Database(entities = arrayOf(Medicine::class), version = 1, exportSchema = false)
public abstract class MedicineRoomDatabase : RoomDatabase() {

    abstract fun medicineDao(): MedicineDAO

    companion object {
        /**
         * Singleton prevents multiple instances of database opening at the same time.
         */
        @Volatile
        private var INSTANCE: MedicineRoomDatabase? = null
        fun getDatabase(context: Context): MedicineRoomDatabase {
            // if the INSTANCE is not null, then return it
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MedicineRoomDatabase::class.java,
                    "Medicine"
                    ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}