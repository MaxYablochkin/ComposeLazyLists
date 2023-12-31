package com.example.lazylistsincompose

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lazylistsincompose.screens.LazyColumnScreen
import com.example.lazylistsincompose.screens.LazyHorizontalGridScreen
import com.example.lazylistsincompose.screens.LazyHorizontalStaggeredGridScreen
import com.example.lazylistsincompose.screens.LazyRowScreen
import com.example.lazylistsincompose.screens.LazyVerticalGridScreen
import com.example.lazylistsincompose.screens.LazyVerticalStaggeredGridScreen
import com.example.lazylistsincompose.screens.MainScreen
import com.example.lazylistsincompose.ui.theme.LazyListsInComposeTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            LazyListsInComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screens.MainScreen.destination,
                        enterTransition = {
                            fadeIn(
                                animationSpec = tween(
                                    durationMillis = 250,
                                    easing = LinearEasing
                                )
                            ) + slideIntoContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Start,
                                animationSpec = tween(400)
                            )
                        },
                        exitTransition = {
                            fadeOut(
                                animationSpec = tween(
                                    durationMillis = 250,
                                    easing = LinearEasing
                                )
                            ) + slideOutOfContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Start,
                                animationSpec = tween(400)
                            )
                        },
                        popEnterTransition = {
                            fadeIn(
                                animationSpec = tween(
                                    durationMillis = 250,
                                    easing = LinearEasing
                                )
                            ) + slideIntoContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.End,
                                animationSpec = tween(400)
                            )
                        },
                        popExitTransition = {
                            fadeOut(
                                animationSpec = tween(
                                    durationMillis = 250,
                                    easing = LinearEasing
                                )
                            ) + slideOutOfContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.End,
                                animationSpec = tween(400)
                            )
                        }
                    ) {
                        composable(Screens.MainScreen.destination) {
                            MainScreen(navController)
                        }
                        composable(Screens.LazyRowScreen.destination) {
                            LazyRowScreen(
                                listAnimals,
                                Modifier.windowInsetsPadding(WindowInsets.statusBars)
                            )
                        }
                        composable(Screens.LazyColumnScreen.destination) {
                            LazyColumnScreen(listAnimals, navController)
                        }
                        composable(Screens.LazyHorizontalGridScreen.destination) {
                            LazyHorizontalGridScreen(
                                listAnimals,
                                Modifier.windowInsetsPadding(WindowInsets.statusBars)
                            )
                        }
                        composable(Screens.LazyVerticalGridScreen.destination) {
                            LazyVerticalGridScreen(
                                listAnimals,
                                Modifier.windowInsetsPadding(WindowInsets.statusBars)
                            )
                        }
                        composable(Screens.LazyVerticalStaggeredGridScreen.destination) {
                            LazyVerticalStaggeredGridScreen(
                                listAnimals,
                                Modifier.windowInsetsPadding(WindowInsets.statusBars)
                            )
                        }
                        composable(Screens.LazyHorizontalStaggeredGridScreen.destination) {
                            LazyHorizontalStaggeredGridScreen(
                                listAnimals,
                                Modifier.windowInsetsPadding(WindowInsets.statusBars)
                            )
                        }
                    }
                }
            }
        }
    }

    companion object {
        val listAnimals = listOf(
            Animal(
                "https://images.pexels.com/photos/3238532/pexels-photo-3238532.jpeg?auto=compress&cs=tinysrgb&w=600",
                "I'm reading a book on anti-gravity. It's impossible to put down."
            ),
            Animal(
                "https://images.pexels.com/photos/1170986/pexels-photo-1170986.jpeg?auto=compress&cs=tinysrgb&w=1600",
                "I used to be a baker, but I couldn't make enough dough."
            ),
            Animal(
                "https://images.pexels.com/photos/1828875/pexels-photo-1828875.jpeg?auto=compress&cs=tinysrgb&w=1600",
                "I'm friends with all electricians. We have good current connections."
            ),
            Animal(
                "https://images.pexels.com/photos/1404819/pexels-photo-1404819.jpeg?auto=compress&cs=tinysrgb&w=1600",
                "I told my wife she was drawing her eyebrows too high. She looked surprised."
            ),
            Animal(
                "https://images.pexels.com/photos/3777622/pexels-photo-3777622.jpeg?auto=compress&cs=tinysrgb&w=1600",
                "I'd tell you a joke about construction, but I'm still working on it."
            ),
            Animal(
                "https://images.pexels.com/photos/2173872/pexels-photo-2173872.jpeg?auto=compress&cs=tinysrgb&w=1600",
                "Don't trust atoms. They make up everything."
            ),
            Animal(
                "https://images.pexels.com/photos/977935/pexels-photo-977935.jpeg?auto=compress&cs=tinysrgb&w=1600",
                "I used to be a baker, but I couldn't make enough dough."
            ),
            Animal(
                "https://images.pexels.com/photos/1317844/pexels-photo-1317844.jpeg?auto=compress&cs=tinysrgb&w=1600",
                "I'm reading a book on anti-gravity. It's impossible to put down."
            ),
            Animal(
                "https://images.pexels.com/photos/2686914/pexels-photo-2686914.jpeg?auto=compress&cs=tinysrgb&w=1600",
                "I'm friends with all electricians. We have good current connections."
            ),
            Animal(
                "https://images.pexels.com/photos/1835008/pexels-photo-1835008.jpeg?auto=compress&cs=tinysrgb&w=1600",
                "I told my wife she was drawing her eyebrows too high. She looked surprised."
            ),
            Animal(
                "https://images.pexels.com/photos/3257811/pexels-photo-3257811.jpeg?auto=compress&cs=tinysrgb&w=1600",
                "I'd tell you a joke about construction, but I'm still working on it."
            ),
            Animal(
                "https://images.pexels.com/photos/4588052/pexels-photo-4588052.jpeg?auto=compress&cs=tinysrgb&w=600",
                "Don't trust atoms. They make up everything."
            ),
            Animal(
                "https://images.pexels.com/photos/4588435/pexels-photo-4588435.jpeg?auto=compress&cs=tinysrgb&w=600",
                "I couldn't figure out how to put my seatbelt on. Then it clicked!"
            ),
            Animal(
                "https://images.pexels.com/photos/2951921/pexels-photo-2951921.jpeg?auto=compress&cs=tinysrgb&w=600",
                "I'm a big fan of whiteboards. I find them quite re-markable."
            ),
            Animal(
                "https://images.pexels.com/photos/5257587/pexels-photo-5257587.jpeg?auto=compress&cs=tinysrgb&w=600",
                "I'm reading a book on anti-gravity. It's impossible to put down."
            ),
            Animal(
                "https://images.pexels.com/photos/2629372/pexels-photo-2629372.jpeg?auto=compress&cs=tinysrgb&w=600",
                "I'm friends with all electricians. We have good current connections."
            ),
            Animal(
                "https://images.pexels.com/photos/106685/pexels-photo-106685.jpeg?auto=compress&cs=tinysrgb&w=600",
                "I told my wife she was drawing her eyebrows too high. She looked surprised."
            ),
            Animal(
                "https://images.pexels.com/photos/1059823/pexels-photo-1059823.jpeg?auto=compress&cs=tinysrgb&w=600",
                "I'd tell you a joke about construction, but I'm still working on it."
            ),
            Animal(
                "https://images.pexels.com/photos/2214495/pexels-photo-2214495.jpeg?auto=compress&cs=tinysrgb&w=600",
                "Don't trust atoms. They make up everything."
            ),
            Animal(
                "https://images.pexels.com/photos/36846/bald-eagle-adler-bird-of-prey-raptor.jpg?auto=compress&cs=tinysrgb&w=600",
                "I used to be a baker, but I couldn't make enough dough."
            ),
        )
    }
}