package com.example.lazylistsincompose.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.lazylistsincompose.Animal

@Composable
fun LazyHorizontalGridScreen(
    animals: List<Animal>,
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        modifier = Modifier.then(modifier),
        rows = GridCells.Adaptive(120.dp),
        contentPadding = PaddingValues(10.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(animals) { animal ->
            PhotoItem(imageUrl = animal.imageUrl)
        }
    }
}

@Composable
private fun PhotoItem(imageUrl: String) =
    AsyncImage(
        model = imageUrl,
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(200.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable { }
    )