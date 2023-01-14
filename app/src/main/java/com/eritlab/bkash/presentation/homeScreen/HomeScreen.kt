package com.eritlab.bkash.presentation.homeScreen

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eritlab.bkash.R
import com.eritlab.bkash.presentation.homeScreen.components.HomeItem
import com.eritlab.bkash.presentation.homeScreen.components.ImageSlider
import com.eritlab.bkash.presentation.theme.backgroundColor
import com.eritlab.bkash.presentation.theme.offWhite
import com.eritlab.bkash.presentation.theme.offWhite2
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
            .verticalScroll(state = lazyScrollState)
            .background(MaterialTheme.colors.offWhite2)
            .padding(bottom = 100.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 5.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                HomeItem(image = R.drawable.send_money, text = "সেন্ড মানি")
                HomeItem(image = R.drawable.mobile_recharge, text = "মোবাইল রিচার্জ")
                HomeItem(image = R.drawable.cash_out, text = "ক্যাশ আউট")
                HomeItem(image = R.drawable.payment, text = "পেমেন্ট")
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                HomeItem(image = R.drawable.add_money, text = "অ্যাড মানি")
                HomeItem(image = R.drawable.pay_bill, text = "পে বিল")
                HomeItem(image = R.drawable.savings, text = "সেভিংস")
                HomeItem(image = R.drawable.loan, text = "লোন")
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                HomeItem(image = R.drawable.bkash_to_bank, text = "বিকাশ টু ব্যাংক")
                HomeItem(image = R.drawable.remittance, text = "রেমিটেন্স")
                HomeItem(image = R.drawable.education, text = "এডুকেশন ফি")
                HomeItem(image = R.drawable.ngo, text = "মাইক্রোফাইন্যান্স")
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(Color.White)
            //   .shadow(elevation = 1.dp, shape = RoundedCornerShape(5.dp))
        ) {
            Column(
                modifier = Modifier.padding(
                    start = 10.dp,
                    end = 10.dp,
                    top = 10.dp,
                    bottom = 10.dp
                ),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "My bKash", fontSize = 12.sp)
                    Text(
                        text = "See All",
                        fontSize = 12.sp,
                        color = MaterialTheme.colors.backgroundColor
                    )
                }
                Divider()
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    HomeItem(image = R.drawable.my_offer, text = "My offer")
                    HomeItem(image = R.drawable.savebill, text = "Save Bill")
                    HomeItem(image = R.drawable.priyo_numbers, text = "Priyo Number")
                    HomeItem(image = R.drawable.phone_number, text = "*Ronju")
                    HomeItem(image = R.drawable.phone_number, text = "Ety")
                }
            }
        }

        ImageSlider(pagerState = state, imageList = imageList)


        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(Color.White)
            //   .shadow(elevation = 1.dp, shape = RoundedCornerShape(5.dp))
        ) {
            Column(
                modifier = Modifier.padding(
                    start = 10.dp,
                    end = 10.dp,
                    top = 10.dp,
                    bottom = 10.dp
                ),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Suggestions", fontSize = 12.sp)
                    Text(
                        text = "See All",
                        fontSize = 12.sp,
                        color = MaterialTheme.colors.backgroundColor
                    )
                }
                Divider()
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    HomeItem(image = R.drawable.play_quiz, text = "Play Quiz")
                    HomeItem(image = R.drawable.bd_news, text = "bdnews24.com")
                    HomeItem(image = R.drawable.shadin_music, text = "Shadin Music")
                    HomeItem(image = R.drawable.quiz_master, text = "Quiz master")
                    HomeItem(image = R.drawable.caretutors, text = "Caretutors")
                }
            }
        }



        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(Color.White)
            //   .shadow(elevation = 1.dp, shape = RoundedCornerShape(5.dp))
        ) {
            Column(
                modifier = Modifier.padding(
                    start = 10.dp,
                    end = 10.dp,
                    top = 10.dp,
                    bottom = 10.dp
                ),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "More Service", fontSize = 12.sp)
                    Text(
                        text = "See All",
                        fontSize = 12.sp,
                        color = MaterialTheme.colors.backgroundColor
                    )
                }
                Divider()
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    HomeItem(image = R.drawable.tickets, text = "Tickets")
                    HomeItem(image = R.drawable.akash, text = "Akash DTH")
                    HomeItem(image = R.drawable.donation, text = "Donation")
                    HomeItem(image = R.drawable.btcl, text = "BTCL")
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    HomeItem(image = R.drawable.ajkerdeal, text = "Ajker Deal")
                    HomeItem(image = R.drawable.daraz, text = "Daraz")
                    HomeItem(image = R.drawable.stiline, text = "Sti Line")
                   HomeItem(image = R.drawable.bdjobs, text = "BD Jobs")
                }
            }
        }

    }
}
