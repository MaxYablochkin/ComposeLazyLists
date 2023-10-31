package com.example.lazylistsincompose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lazylistsincompose.Screens

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun MainScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "LazyLists samples in Compose") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(5.dp),
            ) {
                OutlinedButton(onClick = { navController.navigate(Screens.LazyRowScreen.destination) }) {
                    Text(text = "LazyRow")
                }
                OutlinedButton(onClick = { navController.navigate(Screens.LazyColumnScreen.destination) }) {
                    Text(text = "LazyColumn")
                }
                OutlinedButton(onClick = { navController.navigate(Screens.LazyVerticalGridScreen.destination) }) {
                    Text(text = "LazyVerticalGrid")
                }
                OutlinedButton(onClick = { navController.navigate(Screens.LazyHorizontalGridScreen.destination) }) {
                    Text(text = "LazyHorizontalGrid")
                }
                OutlinedButton(onClick = { navController.navigate(Screens.LazyVerticalStaggeredGridScreen.destination) }) {
                    Text(text = "LazyVerticalStaggeredGrid")
                }
                OutlinedButton(onClick = { navController.navigate(Screens.LazyHorizontalStaggeredGridScreen.destination) }) {
                    Text(text = "LazyHorizontalStaggeredGrid")
                }
            }
        }
    }
}
