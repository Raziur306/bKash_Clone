package com.eritlab.bkash.presentation.splash.component

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.eritlab.bkash.R
import com.eritlab.bkash.presentation.theme.backgroundColor
import com.eritlab.bkash.presentation.theme.offWhite

@Preview(showSystemUi = true)
@Composable
fun SplashScreen() {
    //animated box
    val transition = rememberInfiniteTransition()
    val animWidth by transition.animateFloat(
        initialValue = 20F,
        targetValue = 100F,
        animationSpec = infiniteRepeatable(
            animation = tween(2000),
            repeatMode = RepeatMode.Reverse
        )
    )

    val logoAnimator by transition.animateFloat(
        initialValue = 150f,
        targetValue = 200f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.backgroundColor),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Splash Screen Icon",
                modifier = Modifier
                    .size(logoAnimator.dp)
                    .weight(5f),
            )

            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                //id
                val (rowItem, boxItem) = createRefs()
                Row(
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .constrainAs(rowItem) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(parent.top)
                        },
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                ) {
                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colors.offWhite)
                    )
                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colors.offWhite)
                    )
                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colors.offWhite)
                    )
                }


                Row(
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .constrainAs(boxItem) {
                            start.linkTo(rowItem.start)
                            end.linkTo(rowItem.end)
                            top.linkTo(rowItem.top)
                            bottom.linkTo(rowItem.bottom)
                        },
                    horizontalArrangement = Arrangement.Start
                ) {
                    Box(
                        modifier = Modifier
                            .height(20.dp)
                            .width(animWidth.dp)
                            .clip(CircleShape)
                            .background(Color.White),
                    )
                }
            }
        }

    }
}