package com.example.practicotinder.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LikedCarsScreen(
    likedCars: List<Car>,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A1A1A))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = onBack,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF424242)
                )
            ) {
                Text("← Volver")
            }

            Text(
                text = "🚗 Autos que me gustan",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (likedCars.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "🚫",
                        fontSize = 64.sp,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Text(
                        text = "Aún no has dado like a ningún auto",
                        fontSize = 18.sp,
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "¡Ve a la pantalla principal y encuentra tu auto perfecto!",
                        fontSize = 14.sp,
                        color = Color(0xFFB0B0B0)
                    )
                }
            }
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(likedCars) { car ->
                    LikedCarCard(car = car)
                }
            }
        }
    }
}

@Composable
fun LikedCarCard(car: Car) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF2D2D2D)
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(car.images[0]),
                contentDescription = "Foto de ${car.name}",
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = "${car.brand} ${car.name}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "Año: ${car.year}",
                    fontSize = 16.sp,
                    color = Color(0xFFB0B0B0)
                )
                Text(
                    text = car.description,
                    fontSize = 14.sp,
                    color = Color(0xFFB0B0B0),
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}
