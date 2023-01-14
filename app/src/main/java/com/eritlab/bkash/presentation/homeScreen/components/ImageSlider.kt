package com.eritlab.bkash.presentation.homeScreen.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImageSlider(pagerState: PagerState, imageList: List<Int>) {
    val currentPosition = remember {
        mutableStateOf(0)
    }
    var key by remember { mutableStateOf(false) }
    //pager animation
    LaunchedEffect(key1 = key) {
        launch {
            delay(3000)
            with(pagerState) {
                val target = if (currentPage < pageCount - 1) currentPage + 1 else 0
                currentPosition.value = target
                animateScrollToPage(
                    page = target,
                    pageOffset = 0f,
                )
                key = !key

            }
        }
    }

    Column(modifier = Modifier.wrapContentHeight()) {
        HorizontalPager(
            state = pagerState,
            count = imageList.size,
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
        ) { pagerPosition ->
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(contentAlignment = Alignment.BottomCenter) {
                    Image(
                        painter = painterResource(id = imageList[pagerPosition]),
                        contentDescription = "Slider Image"
                    )
                }
            }
        }
        DotIndicator(totalDots = imageList.size, selectedIndex = currentPosition.value)
    }


}

//dot Indicator
@Composable
private fun DotIndicator(totalDots: Int, selectedIndex: Int) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.Center,
    ) {
        items(totalDots) { index ->
            if (index == selectedIndex) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(color = Color.DarkGray)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(color = Color.LightGray)
                )
            }

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}
