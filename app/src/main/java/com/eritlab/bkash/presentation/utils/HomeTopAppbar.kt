package com.eritlab.bkash.presentation.common

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.eritlab.bkash.R
import com.eritlab.bkash.presentation.theme.backgroundColor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue


@Composable
fun HomeTopAppbar(scope: CoroutineScope, scaffoldState: ScaffoldState) {
    //animation
    val animState = remember {
        mutableStateOf(false)
    }
    val animBias by animateFloatAsState(
        targetValue = if (animState.value) 1f else 0f,
        animationSpec = tween<Float>(
            durationMillis = 1500
        )
    )
    if (animBias.absoluteValue == 1f) {
        animState.value = false
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    MaterialTheme.colors.backgroundColor,
                    shape = RoundedCornerShape(bottomEnd = 8.dp, bottomStart = 8.dp)
                )
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.person
                    ), contentDescription = "User QR", modifier = Modifier
                        .clip(CircleShape)
                        .size(50.dp)
                )
                //balance
                Column(modifier = Modifier
                    .padding(start = 5.dp, end = 110.dp)
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        animState.value = !animState.value
                    }) {
                    Text(text = "Raziur Rahaman", color = Color.White)
                    Box(
                        //  contentAlignment = Alignment.CenterStart,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .background(Color.White, RoundedCornerShape(50.dp))
                            .padding(2.dp)
                    ) {
                        ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
                            val (image, text) = createRefs()
                            Image(
                                painter = painterResource(id = R.drawable.balance_taka),
                                contentDescription = "Balance Icon",
                                modifier = Modifier
                                    .constrainAs(image) {
                                        linkTo(
                                            start = parent.start,
                                            end = parent.end,
                                            bias = animBias
                                        )
                                        top.linkTo(parent.top)
                                        bottom.linkTo(parent.bottom)
                                    }
                                    .size(25.dp)
                            )
                            Text(
                                text = if (animBias.absoluteValue >= 0.5f) "50000.89" else "ব্যালেন্স দেখুন",
                                color = MaterialTheme.colors.backgroundColor,
                                modifier = Modifier.constrainAs(text) {
                                    linkTo(start = parent.start, end = parent.end)
                                }
                            )

                            Log.d("Ronju", animBias.absoluteValue.toString())

                        }

                    }

                }
            }
            Row(
                modifier = Modifier.weight(0.3f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.loyalty_points_trophy_icon
                    ),
                    contentDescription = "User QR",
                    modifier = Modifier
                        .weight(1f)
                        .size(30.dp)
                        .clip(CircleShape)
                        .clickable {

                        }
                )
                Image(
                    painter = painterResource(
                        id = R.drawable.logo
                    ), contentDescription = "User QR",
                    modifier = Modifier
                        .weight(1f)
                        .size(30.dp)
                        .clip(CircleShape)
                        .clickable {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        }
                )
            }

        }

    }
}