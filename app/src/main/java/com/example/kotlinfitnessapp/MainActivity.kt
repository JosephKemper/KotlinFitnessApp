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

data class Exercise(
    val sets: Int?,
    val reps: Int?,
    val weight: Int?,
    val minutes: Int?
)
data class Workout(
    val exercise: Exercise?,
    val name: String,
    val description: String?
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
    var workout = Workout(name = "", description = null, exercise = null)

    // Add text field to collect workout name
    CustomTextField(
        value = workout.name,
        onValueChange = { workout.name = it }
    )

    // Add optional text field for the workout description
    if (workout.description != null) {
        CustomTextField(
            value = workout.description!!,
            onValueChange = { workout.description = it }
        )
    }

    // Save the workout when the user clicks the save button.
    Button(onClick = { onSaveWorkout(workout) }) {
        Text(text = "Save")
    }
}

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit
) {
    // Create a text field using the native Android EditText composable.
    TextField(
        value = value,
        onValueChange = onValueChange
    )

    // Add a border around the text field.
    Box(
        modifier = Modifier.border(
            width = 1.dp,
            color = Color.Gray
        )
    ) {
        // Add the text field to the box.
        TextField(
            value = value,
            onValueChange = onValueChange
        )
    }
}