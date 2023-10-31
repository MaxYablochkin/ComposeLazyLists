package com.example.lazylistsincompose

sealed class Screens(val destination: String) {
    object MainScreen : Screens("MainScreen")
    object LazyRowScreen : Screens("LazyRowScreen")
    object LazyColumnScreen : Screens("LazyColumnScreen")
    object LazyVerticalGridScreen : Screens("LazyVerticalGridScreen")
    object LazyHorizontalGridScreen : Screens("LazyHorizontalGridScreen")
    object LazyVerticalStaggeredGridScreen : Screens("LazyVerticalStaggeredGridScreen")
    object LazyHorizontalStaggeredGridScreen : Screens("LazyHorizontalStaggeredGridScreen")
}
