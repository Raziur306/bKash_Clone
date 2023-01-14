package com.eritlab.bkash.presentation.homeScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

@Composable
fun HomeItem(image: Int, text: String) {
    Column() {
        Image(painter = painterResource(id = image), contentDescription = "Menu Item")
        Text(text = text)
    }
}