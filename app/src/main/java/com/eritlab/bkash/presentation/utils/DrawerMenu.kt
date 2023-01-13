package com.eritlab.bkash.presentation.utils

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.eritlab.bkash.presentation.theme.backgroundColor
import kotlinx.coroutines.CoroutineScope

@Composable
fun DrawerMenu(
    menuItem: List<DrawerMenuItem>,
    scrollState: ScrollState,
    scaffoldState: ScaffoldState,
    scope: CoroutineScope,
    selectedItem: MutableState<DrawerMenuItem>
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "বিকাশ",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.backgroundColor
            )
            Text(text = " মেনু", color = MaterialTheme.colors.backgroundColor)
        }
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
    }
    Spacer(modifier = Modifier.height(20.dp))
    Column(modifier = Modifier.verticalScroll(scrollState)) {
        menuItem.forEach { item ->
            when {
                item.isDivider -> {
                    Divider(modifier = Modifier.padding(top = 15.dp, bottom = 15.dp))
                }
                else -> {
                    DrawerItemDesign(
                        item = item,
                        scaffoldState = scaffoldState,
                        scope = scope,
                        selectedItem = selectedItem
                    )
                }
            }
        }

    }
}