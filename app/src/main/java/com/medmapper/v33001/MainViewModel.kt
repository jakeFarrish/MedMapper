package com.medmapper.v33001

import android.util.Log
import android.view.View
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.medmapper.v33001.dto.Medicine
import com.medmapper.v33001.dto.User
import com.medmapper.v33001.service.IMedicineService

class MainViewModel(var medicineService : IMedicineService) : ViewModel() {

    private val NEW_MEDICATION = "New Medication"
    private val _medicine = MutableLiveData<List<Medicine>>()
    val medicine: LiveData<List<Medicine>> get() = _medicine
    var selectedMedicine by mutableStateOf(Medicine())
    var user: User? = null

    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance().apply {
        firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }

    fun listenToMedicine() {
        user?.let { user ->
            firestore.collection("users").document(user.uid).collection("medicine")
                .addSnapshotListener { snapshot, e ->
                    if (e != null) {
                        Log.w("Listen failed", e)
                        return@addSnapshotListener
                    }
                    snapshot?.let {
                        val allMedicine = it.documents.mapNotNull { doc ->
                            doc.toObject(Medicine::class.java)
                        } + Medicine(name = NEW_MEDICATION)
                        _medicine.value = allMedicine.toList()
                    }
                }
        }
    }

    // TBD code here
    fun fetchMedicine() {
        /*viewModelScope.launch {
            var innerMedicine = medicineService.fetchMedicine()
            medicine.postValue(innerMedicine)
        }*/
    }

    fun saveMedicine() {
        user?.let {
            user ->
            val document =
                if (selectedMedicine.medicationID == null || selectedMedicine.medicationID.isEmpty()) {
                    // create a new medicine
                    firestore.collection("users").document(user.uid).collection("medications").document()
                } else {
                    // update an existing specimen
                    firestore.collection("users").document(user.uid).collection("medications").document()
                }
            selectedMedicine.medicationID = document.id
            val handle = document.set(selectedMedicine)
            handle.addOnSuccessListener { Log.d("Firebase", "Document Saved") }
            handle.addOnFailureListener { Log.d("Firebase", "Save failed $it") }
        }
    }

    fun saveUser() {
        user?.let { user ->
            val handle = firestore.collection("users").document(user.uid).set(user)
            handle.addOnSuccessListener { Log.d("Firebase", "Document Saved") }
            handle.addOnFailureListener { Log.e("Firebase", "Save failed $it") }
        }
    }
}