package com.example.healthandfitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.healthandfitnessapp.ui.theme.HealthAndFitnessAppTheme
val workoutList = mutableListOf<Exercise>() // Stores the different exercises that make up a workout

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HealthAndFitnessAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("My Beautiful Angel Queen")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface (color = Color.Blue) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HealthAndFitnessAppTheme {
        Greeting("Android")
    }
}

// Define function to get input from user


data class Exercise(
    val name: String,
    val time: Int? = null, // time in minutes
    val weight: Double? = null, // weight in pounds
    val reps: Int? = null,
    val sets: Int? = null
)

fun CreateExercise(){

}