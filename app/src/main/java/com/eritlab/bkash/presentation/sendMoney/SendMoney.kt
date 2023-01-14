package com.eritlab.bkash.presentation.sendMoney

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SendMoney() {
    val phoneNumber = remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier.padding(10.dp)) {
        Text(text = "প্রাপক", fontSize = 12.sp)
        Row(modifier = Modifier.fillMaxWidth()) {

        }
    }
}