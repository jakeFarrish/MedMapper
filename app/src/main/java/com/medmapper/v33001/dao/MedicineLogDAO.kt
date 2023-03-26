package com.medmapper.v33001.dao
import com.google.firebase.firestore.FirebaseFirestore
import com.medmapper.v33001.dto.MedicineLog

class MedicineLogDAO (private val db: FirebaseFirestore) {

    fun addLog(medicineLog: MedicineLog){
        db.collection("medicineLogs")
            .add(medicineLog)
            .addOnSuccessListener { documentReference ->
                println("Log added. ID = ${documentReference.id}")
            }
            .addOnFailureListener{ exception ->
                println("Error adding log. ${exception.message}")
            }
    }
    fun updateLog(medicineLog: MedicineLog){
        db.collection("medicineLogs")
            .document(medicineLog.id)
            .set(medicineLog)
            .addOnSuccessListener {
                println("Log updated. ID = ${medicineLog.id}")
            }
            .addOnFailureListener { exception ->
                println("Error updating log. ${exception.message} ")
            }
    }
    fun deleteLog(medicineLogId: String) {
        db.collection("medicineLogs")
            .document(medicineLogId)
            .delete()
            .addOnSuccessListener {
                println("Log deleted. ID = $medicineLogId")
            }
            .addOnFailureListener { exception ->
                println("Error deleting log. ${exception.message}")

            }
    }
    fun getLog(userId: String): List<MedicineLog> {
        val medicineLogs = mutableListOf<MedicineLog>()

        db.collection("medicineLogs")
            .whereEqualTo("userId", userId)
            .get()
            .addOnSuccessListener { querySnapshot ->
                for(document in querySnapshot) {
                    val medicineLog = document.toObject(MedicineLog::class.java)
                    medicineLogs.add(medicineLog)
                }
            }
            .addOnFailureListener { exception ->
                println("Error retrieving log. ${exception.message}")

            }
        return medicineLogs
    }
}