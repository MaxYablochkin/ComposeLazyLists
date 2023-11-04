package com.example.lazylistsincompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.lazylistsincompose.Animal

@Composable
fun LazyRowScreen(
    animals: List<Animal>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = Modifier.then(modifier),
        contentPadding = PaddingValues(10.dp)
    ) {
        items(animals) { animal ->
            CardAnimals(
                imageUrl = animal.imageUrl,
                text = animal.text.take(25),
                modifier = Modifier.padding(horizontal = 3.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CardAnimals(
    imageUrl: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier.then(modifier),
        onClick = {}
    ) {
        Box(
            modifier = Modifier
                .height(150.dp)
                .width(120.dp)
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black),
                            startY = 200f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 10.dp, end = 15.dp, bottom = 10.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = text,
                    fontSize = 15.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}