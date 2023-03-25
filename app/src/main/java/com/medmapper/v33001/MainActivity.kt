package com.medmapper.v33001

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.medmapper.v33001.dto.User
import com.medmapper.v33001.ui.theme.MedMapperTheme
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : ComponentActivity() {

    private var firebaseUser: FirebaseUser? = FirebaseAuth.getInstance().currentUser
    private val viewModel: MainViewModel by viewModel<MainViewModel>()

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
}

@Composable
fun SpecimenFacts(name:String) {
    var medicineName by remember {mutableStateOf("")}
    var prescriptionStrength by by remember{mutableStateOf( "")}
    var startDate by remember{mutableStateOf( "")}
    var intakeFrequency by remember{mutableStateOf("")}
    var prescriptionLength by remember{mutableStateOf("")}
    val context=LocalContext.current
   Column {
       OutlinedTextField (
           value = medicineName,
           onValueChange = {medicineName= it},
           label= {Text(stringResource(R.string.medicineName))}
       )
       OutlinedTextField (
           value = prescriptionStrength
           onValueChange = {prescriptionStrength= it},
           label= {Text(stringResource(R.string.prescriptionStrength))}
       )
       OutlinedTextField (
           value = startDate,
           onValueChange = {startDate= it},
           label= {Text(stringResource(R.string.startDate))}
       )
       OutlinedTextField (
           value = intakeFrequency,
           onValueChange = {intakeFrequency= it},
           label= {Text(stringResource(R.string.intakeFrequency))}
       )
       OutlinedTextField (
           value = prescriptionLength,
           onValueChange = {prescriptionLength it},
           label= {Text(stringResource(R.string.prescriptionLength))}
       )
       Button (
           onClick = { Toast.makeText(context,text: "$medicineName $prescriptionStrength $startDate $intakeFrequency $prescriptionLength",
               Toast.LENGTH_LONG).show()})
       {Text(text="Save Info ")}

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MedMapperTheme {
        Greeting("Android")
    }
}