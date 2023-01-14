package com.eritlab.bkash.presentation.homeScreen

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.eritlab.bkash.R
import com.eritlab.bkash.presentation.homeScreen.components.ImageSlider
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(lazyScrollState: ScrollState) {
    //pager state
    val state = rememberPagerState()
    val imageList = listOf(
        R.drawable.image_1,
        R.drawable.image_2,
        R.drawable.image_3,
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(state = lazyScrollState, orientation = Orientation.Vertical)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
        }
        ImageSlider(pagerState = state, imageList = imageList)

    }
}