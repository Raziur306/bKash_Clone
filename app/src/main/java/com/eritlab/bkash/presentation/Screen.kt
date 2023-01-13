package com.eritlab.bkash.presentation

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object LoginScreen : Screen("login_screen")
    object FragmentScreen : Screen("fragment_Screen")
    object HomeScreen : Screen("home_screen")
    object InboxScreen : Screen("inbox_screen")
    object QRScreen : Screen("qr_screen")
}