package com.example.lazylistsincompose.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.lazylistsincompose.Animal

@Composable
fun LazyHorizontalStaggeredGridScreen(
    animals: List<Animal>,
    modifier: Modifier = Modifier
) {
    LazyHorizontalStaggeredGrid(
        modifier = Modifier.then(modifier),
        rows = StaggeredGridCells.Adaptive(120.dp),
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalItemSpacing = 5.dp,
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
            .clip(RoundedCornerShape(12.dp))
            .clickable { }
    )