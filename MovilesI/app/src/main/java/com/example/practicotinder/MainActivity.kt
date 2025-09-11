package com.example.practicotinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.practicotinder.data.Car
import com.example.practicotinder.data.CarRepository
import com.example.practicotinder.ui.screens.LikedCarsScreen
import com.example.practicotinder.ui.screens.MainScreen
import com.example.practicotinder.ui.theme.PracticoTinderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticoTinderTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CarTinderApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CarTinderApp(
    modifier: Modifier = Modifier
) {
    var showLikedCars by remember { mutableStateOf(false) }
    var availableCars by remember { mutableStateOf(CarRepository.getAllCars()) }
    var likedCars by remember { mutableStateOf<List<Car>>(emptyList()) }

    fun likeCar(car: Car) {
        likedCars = likedCars + car
        availableCars = availableCars.filter { it.id != car.id }
    }
    
    fun dislikeCar(car: Car) {
        availableCars = availableCars.filter { it.id != car.id }
    }
    
    if (showLikedCars) {
        LikedCarsScreen(
            likedCars = likedCars,
            onBack = { showLikedCars = false }
        )
    } else {
        MainScreen(
            onNavigateToLiked = { showLikedCars = true },
            cars = availableCars,
            likedCars = likedCars,
            onLikeCar = { car -> likeCar(car) },
            onDislikeCar = { car -> dislikeCar(car) }
        )
    }
}