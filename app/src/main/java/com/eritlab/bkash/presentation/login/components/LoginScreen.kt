package com.eritlab.bkash.presentation.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.eritlab.bkash.presentation.theme.backgroundColor
import com.eritlab.bkash.R
import com.eritlab.bkash.presentation.Screen
import com.eritlab.bkash.presentation.common.keyboardAsState
import com.eritlab.bkash.presentation.theme.darkWhite
import com.eritlab.bkash.presentation.theme.offWhite


@Composable
fun LoginScreen(navController: NavController) {
    //state
    var text by remember { mutableStateOf("") }
    val keyboardHeight by keyboardAsState()
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            modifier = Modifier
                .padding(top = 8.dp, end = 15.dp, start = 15.dp)
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.End)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colors.backgroundColor,
                        shape = CircleShape
                    ), horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "English",
                    color = MaterialTheme.colors.backgroundColor,
                    modifier = Modifier
                        .padding(10.dp)

                )
            }
            Spacer(modifier = Modifier.height(80.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bkash_logo_default),
                    contentDescription = "bKash Logo"
                )
                Image(
                    painter = painterResource(id = R.drawable.onboarding_qr_hint),
                    contentDescription = "QR Code"
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "আপনার বিকাশ একাউন্টে", fontSize = 22.sp)
            Text(text = "লগ ইন করুন", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = "একাউন্ট নাম্বার")
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "+88 01737956676", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(5.dp))
            Divider(color = MaterialTheme.colors.offWhite)
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "বিকাশ পিন")
                Text(text = "পিন ভুলে গিয়েছেন?", color = MaterialTheme.colors.backgroundColor)
            }
            Spacer(modifier = Modifier.height(10.dp))



            TextField(
                visualTransformation = PasswordVisualTransformation(),
                singleLine = true,
                value = text,
                onValueChange = { value ->
                    text = if (value.length <= 5) value else text
                },
                label = { Text("বিকাশ পিন নাম্বার দিন") },
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = MaterialTheme.colors.backgroundColor,
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                ),

                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .fillMaxWidth()
            )
            Divider(color = MaterialTheme.colors.darkWhite)


        }


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = (keyboardHeight / 2.49).dp)
                .clickable {
                    if (text.length == 5) {
                        navController.popBackStack()
                        navController.navigate(Screen.FragmentScreen.route)
                    }
                }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(
                        if (text.length == 5)
                            MaterialTheme.colors.backgroundColor
                        else
                            MaterialTheme.colors.offWhite
                    )
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "পরবর্তী", fontSize = 18.sp, color = Color.White)
                Image(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Arrow Forward",
                    colorFilter = ColorFilter.tint(Color.White),
                    modifier = Modifier.size(28.dp)
                )
            }
        }
    }
}

