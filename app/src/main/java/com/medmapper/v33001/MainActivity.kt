package com.medmapper.v33001

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.medmapper.v33001.dto.Medicine
import com.medmapper.v33001.dto.User
import com.medmapper.v33001.ui.theme.MedMapperTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private var firebaseUser: FirebaseUser? = FirebaseAuth.getInstance().currentUser
    private var selectedMedicine: Medicine? = null
    private val viewModel: MainViewModel by viewModel<MainViewModel>()
    private var inMedicineName : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            firebaseUser?.let {
                val user = User(it.uid, "")
                viewModel.user = user
                viewModel.listenToMedicine()
            }
            val medicine by viewModel.medicine.observeAsState(initial = emptyList())
            MedMapperTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }

    @Composable
    fun medicineSpinner(medicine: List<Medicine>) {
        var medicineText by remember { mutableStateOf("Medicine Collection") }
        var expanded by remember { mutableStateOf(false) }
        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Row(Modifier
                .padding(24.dp)
                .clickable {
                    expanded = !expanded
                }
                .padding(8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = medicineText, fontSize = 18.sp, modifier = Modifier.padding(end = 8.dp))
                Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "")
                DropdownMenu(expanded = expanded, onDismissRequest = {expanded = false}) {
                    medicine.forEach {
                        medicine -> DropdownMenuItem(onClick = {
                            expanded = false

                            if (medicine.name == viewModel.NEW_MEDICATION) {
                                // new medicine
                                medicineText = ""
                                medicine.name = ""
                            } else {
                                // existing medicine
                                medicineText = medicine.toString()
                                selectedMedicine = Medicine()
                                inMedicineName = medicine.name
                            }
                        viewModel.selectedMedicine = medicine
                        viewModel.fetchMedicine()
                        }) {
                            Text(text = medicine.toString())
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MedMapperTheme {
            Greeting("Android")
        }
    }
}