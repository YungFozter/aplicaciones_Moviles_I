package com.example.practicotinder.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.practicotinder.data.Car
import com.example.practicotinder.data.CarRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    onNavigateToLiked: () -> Unit,
    cars: List<Car>,
    likedCars: List<Car>,
    onLikeCar: (Car) -> Unit,
    onDislikeCar: (Car) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A1A1A))
            .padding(16.dp)
    ) {
        Text(
            text = "🚗 CarTinder",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        if (cars.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "¡No hay más autos!",
                        fontSize = 24.sp,
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Button(
                        onClick = onNavigateToLiked,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFE91E63)
                        )
                    ) {
                        Text("Ver autos que me gustan")
                    }
                }
            }
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(cars) { car ->
                    CarCard(
                        car = car,
                        onLike = { likedCar ->
                            onLikeCar(likedCar)
                        },
                        onDislike = { dislikedCar ->
                            onDislikeCar(dislikedCar)
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = onNavigateToLiked,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE91E63)
            )
        ) {
            Text("Ver autos que me gustan (${likedCars.size})")
        }
    }
}

@Composable
fun CarCard(
    car: Car,
    onLike: (Car) -> Unit,
    onDislike: (Car) -> Unit
) {
    var currentImageIndex by remember { mutableStateOf(0) }
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // Imagen del auto
            Image(
                painter = rememberAsyncImagePainter(car.images[currentImageIndex]),
                contentDescription = "Foto de ${car.name}",
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        currentImageIndex = (currentImageIndex + 1) % car.images.size
                    },
                contentScale = ContentScale.Crop
            )

            // Información del auto
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(Color(0x99000000))
                    .padding(16.dp)
            ) {
                Text(
                    text = "${car.brand} ${car.name}",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "Año: ${car.year}",
                    fontSize = 16.sp,
                    color = Color.White
                )
                Text(
                    text = car.description,
                    fontSize = 14.sp,
                    color = Color.White
                )
                
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = { onDislike(car) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Red
                        )
                    ) {
                        Text("✖")
                    }
                    
                    Button(
                        onClick = { onLike(car) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Green
                        )
                    ) {
                        Text("♥")
                    }
                }
            }
        }
    }
}
