package com.medmapper.v33001

import android.util.Log
import android.view.View
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.medmapper.v33001.dto.Medicine
import com.medmapper.v33001.dto.User
import com.medmapper.v33001.service.IMedicineService
import kotlinx.coroutines.launch

class MainViewModel(var medicineService : IMedicineService) /*= MedicineService())*/ : ViewModel() {

    internal val NEW_MEDICATION = "New Medication"
    var medicine : MutableLiveData<List<Medicine>> = MutableLiveData<List<Medicine>>()
    var selectedMedicine by mutableStateOf(Medicine())
    var user: User? = null

    private lateinit var firestore: FirebaseFirestore

    init {
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }

    fun listenToMedicine() {
        user?.let {
            user ->
            firestore.collection("users").document(user.uid).collection("medicine")
                .addSnapshotListener { snapshot, e ->
                    // handle the error if there is one, and then return
                    if (e != null) {
                        Log.w("Listen failed", e)
                        return@addSnapshotListener
                    }
                    // if we reached this point, there was not an error
                    snapshot?.let {
                        val allMedicine = ArrayList<Medicine>()
                        allMedicine.add(Medicine(name = NEW_MEDICATION))
                        val documents = snapshot.documents
                        documents.forEach {
                            val medicine = it.toObject(Medicine::class.java)
                            medicine?.let {
                                allMedicine.add(it)
                            }
                        }
                        medicine.value = allMedicine
                    }
                }
        }
    }

    // TBD code here
    fun fetchMedicine() {
        viewModelScope.launch {
            var innerMedicine = medicineService.fetchMedicine()
            medicine.postValue(innerMedicine)
        }
    }

    fun saveMedicine() {
        user?.let {
            user ->
            val document =
                if (selectedMedicine.id == null || selectedMedicine.id.isEmpty()) {
                    // create a new medicine
                    firestore.collection("users").document(user.uid).collection("medications").document()
                } else {
                    // update an existing specimen
                    firestore.collection("users").document(user.uid).collection("medications").document()
                }
            selectedMedicine.id = document.id
            val handle = document.set(selectedMedicine)
            handle.addOnSuccessListener {
                Log.d("Firebase", "Document Saved")
            }
            handle.addOnFailureListener {
                Log.d("Firebase", "Save failed $it")
            }
        }
    }

    fun saveUser() {
        user?.let {
            user ->
            val handle = firestore.collection("users").document(user.uid).set(user)
            handle.addOnSuccessListener { Log.d("Firebase", "Document Saved") }
            handle.addOnFailureListener { Log.e("Firebase", "Save failed $it") }
        }
    }
}