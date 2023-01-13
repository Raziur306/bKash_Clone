package com.eritlab.bkash.presentation

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eritlab.bkash.R
import com.eritlab.bkash.presentation.component.FragmentScreen
import com.eritlab.bkash.presentation.login.components.LoginScreen
import com.eritlab.bkash.presentation.splash.component.SplashScreen
import com.eritlab.bkash.presentation.theme.BKashTheme
import com.eritlab.bkash.presentation.theme.backgroundColor
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BKashTheme {
                window.statusBarColor = ContextCompat.getColor(baseContext, R.color.pinkColor)
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Navigate(LocalContext.current)
                }
            }
        }
    }
}

@Composable
private fun Navigate(context: Context) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.FragmentScreen.route
    )
    {
        composable(Screen.SplashScreen.route) {
            SplashScreen()
            LaunchedEffect(key1 = true) {
                delay(5000L)
                navController.popBackStack()
                navController.navigate(Screen.LoginScreen.route)
            }
        }
        composable(Screen.LoginScreen.route) {
            (context as Activity).window?.statusBarColor =
                ContextCompat.getColor(context, R.color.offWhite)
            LoginScreen(navController)
        }
        composable(Screen.FragmentScreen.route) {
            (context as Activity).window?.statusBarColor =
                MaterialTheme.colors.backgroundColor.toArgb()
            FragmentScreen()
        }
    }

}