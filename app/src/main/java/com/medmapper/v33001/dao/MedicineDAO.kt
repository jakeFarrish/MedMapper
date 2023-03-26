package com.medmapper.v33001.dao
import com.google.firebase.firestore.FirebaseFirestore
import com.medmapper.v33001.dto.Medicine

class MedicineDAO (private val db: FirebaseFirestore) {

    fun addMedicine (medicine: Medicine){
        db.collection("medicines")
            .add(medicine)
            .addOnSuccessListener { documentReference ->
                println("Medicine added. ID = ${documentReference.id}")
            }
            .addOnFailureListener {exception ->
                println("Error adding medicine. ID = ${exception.message}")
            }
    }
    fun updateMedicine (medicine: Medicine){
        db.collection("medicines")
            .document(medicine.id)
            .set(medicine)
            .addOnSuccessListener {
                println("Medicine updated. ID = ${medicine.id}")
            }
            .addOnFailureListener {exception ->
                println("Error updating medicine. ${exception.message}")
            }
    }
    fun deleteMedication (medicineId: String) {
        db.collection("medicines")
            .document(medicineId)
            .delete()
            .addOnSuccessListener {
                println("Medicine was deleted. ID = $medicineId")
            }
            .addOnFailureListener {exception ->
                println("Error deleting medicine. ${exception.message}")
            }
    }
}