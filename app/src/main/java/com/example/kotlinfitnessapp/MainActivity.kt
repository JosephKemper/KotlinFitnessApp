package com.example.kotlinfitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    workoutName: String,
    workoutDescription: String?,
    onSaveWorkout: (workoutName: String, workoutDescription: String?) -> Unit
){
    //
}
