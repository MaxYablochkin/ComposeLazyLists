package com.example.lazylistsincompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.lazylistsincompose.Animal

@Composable
fun LazyColumnScreen(animals: List<Animal>) {
    LazyColumn(contentPadding = PaddingValues(10.dp)) {
        items(animals) { animal ->
            CardAnimals(
                imageUrl = animal.imageUrl,
                text = animal.text,
                modifier = Modifier.padding(vertical = 5.dp)
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
    OutlinedCard(
        modifier = Modifier.then(modifier),
        onClick = {}
    ) {
        Row {
            Box(
                modifier = Modifier
                    .height(150.dp)
                    .width(120.dp)
            ) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clip(RoundedCornerShape(12.dp))
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(12.dp))
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color.Black),
                                startY = 200f
                            )
                        )
                )
            }
            Text(text = text, fontWeight = FontWeight.Medium, modifier = Modifier.padding(15.dp))
        }
    }
}