package com.example.kotlinfitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    var name: String,
    var description: String?
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
                        Button(onClick = { /* Do something when the button is clicked. */ },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = "Create Workout")
                        }
                    }

                }
            }
        }
    }
}


@Composable
fun CreateWorkout(
    exercise: Exercise? = null,
    onSaveWorkout: (workout: Workout) -> Unit
) {
    // Create a new var variable to store the workout data.
    val workout = remember {
        mutableStateOf(Workout(name = "", description = null, exercise = null))


    }
    // Add text field to collect workout name
    BasicTextField(
        value = workout.value.name,
        onValueChange = { workout.value.name = it }
    )

    // Add optional text field for the workout description
    if (workout.value.description != null) {
        BasicTextField(
            value = workout.value.description!!,
            onValueChange = { workout.value.description = it }
        )
    }

    // Save the workout when the user clicks the save button.
    Button(onClick = { onSaveWorkout(workout.value) }) {
        Text(text = "Save")
    }
}

