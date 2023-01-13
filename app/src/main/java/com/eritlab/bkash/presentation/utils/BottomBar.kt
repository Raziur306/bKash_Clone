package com.eritlab.bkash.presentation.common


import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.eritlab.bkash.presentation.theme.backgroundColor
import com.eritlab.bkash.presentation.utils.BottomBarItem

@Composable
fun BottomBar(bottomList: List<BottomBarItem>, bottomBarSelectedItem: MutableState<BottomBarItem>) {
    BottomNavigation(
        backgroundColor = Color.White
    ) {
        bottomList.forEach { item ->
            BottomNavigationItem(
                label = {
                    Text(
                        text = item.title,
                        color = if (bottomBarSelectedItem.value == item) MaterialTheme.colors.backgroundColor else LocalContentColor.current,
                    )
                },
                selected = bottomBarSelectedItem.value == item,
                onClick = {
                    bottomBarSelectedItem.value = item
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = "Bottom Item",
                        tint = if (bottomBarSelectedItem.value == item) MaterialTheme.colors.backgroundColor else LocalContentColor.current,
                    )
                },
            )
        }

    }
}