package com.example.kotlinfitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import androidx.navigation.findNavController
import com.example.kotlinfitnessapp.ui.theme.KotlinFitnessAppTheme


val workoutList = mutableListOf<Workout>() // store a list of all created workouts
data class Exercise(
    var sets: Int?,
    var reps: Int?,
    var weight: Int?,
    var minutes: Int?
)
data class Workout(
    var exercise: Exercise?,
    var name: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinFitnessAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        // Button for creating exercises
                        Button(
                            onClick = { /* Do something when the button is clicked. */ },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = "Create Exercise")
                        }

                        // Add some space between the buttons.
                        Spacer(modifier = Modifier.padding(top = 16.dp))

                        // Button for creating workouts
                        Button(onClick = {
                            setContent {
                                CreateWorkout(onSaveWorkout = { workout ->
                                    // add workout to the workoutList
                                    workoutList.add(workout)
                                    val navController = findNavController(androidx.navigation.fragment.R.id.nav_host_fragment_container)
                                    navController.navigate("MainActivity")
                                })
                            }
                        }) {
                            Text(text = "Create Workout")
                        }
                    }

                }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateWorkout(
    exercise: Exercise? = null,
    onSaveWorkout: (workout: Workout) -> Unit
) {
    // Create a new var variable to store the workout data.
    val workout = remember {
        mutableStateOf(Workout(name = "", exercise = null))
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        val defaultText = remember { mutableStateOf("")}
        val focusRequester = remember { FocusRequester() }
        Text(text = "Workout Name")
        // Add text field to collect workout name
        TextField(
            value = defaultText.value,
            onValueChange = {newValue ->
                defaultText.value = newValue },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
                .focusRequester(focusRequester)
        )
        LaunchedEffect(Unit){
            focusRequester.requestFocus()
        }

        // Save the workout when the user clicks the save button.
        Button(onClick = {
            workout.value.name = defaultText.value
            onSaveWorkout(workout.value)
        }) {
            Text(text = "Save")
        }
    }
}

