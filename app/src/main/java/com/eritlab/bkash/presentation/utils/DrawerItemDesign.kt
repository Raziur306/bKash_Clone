package com.eritlab.bkash.presentation.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.eritlab.bkash.presentation.theme.backgroundColor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun DrawerItemDesign(
    item: DrawerMenuItem,
    scaffoldState: ScaffoldState,
    scope: CoroutineScope,
    selectedItem: MutableState<DrawerMenuItem>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
            .padding(top = 2.dp, bottom = 2.dp, end = 8.dp)
            .clip(
                RoundedCornerShape(
                    topStartPercent = 0,
                    topEndPercent = 50,
                    bottomStartPercent = 0,
                    bottomEndPercent = 50
                )
            )
            .clickable {
                selectedItem.value = item
                scope.launch {
                    delay(250)
                    scaffoldState.drawerState.close()
                }
            },
        verticalAlignment = Alignment.CenterVertically

    ) {
        Image(
            imageVector = item.icon!!, contentDescription = item.title,
            modifier = Modifier.weight(0.5f),
            colorFilter = ColorFilter.tint(MaterialTheme.colors.backgroundColor)
        )
        Text(
            text = item.title!!,
            color = MaterialTheme.colors.backgroundColor,
            modifier = Modifier.weight(2.0f),
        )
    }

}