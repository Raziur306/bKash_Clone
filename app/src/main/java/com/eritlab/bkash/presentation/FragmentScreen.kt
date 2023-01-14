package com.eritlab.bkash.presentation.component


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eritlab.bkash.presentation.common.BottomBar
import com.eritlab.bkash.presentation.utils.BottomBarItem
import com.eritlab.bkash.presentation.common.HomeTopAppbar
import com.eritlab.bkash.presentation.homeScreen.HomeScreen
import com.eritlab.bkash.presentation.utils.DrawerMenu
import com.eritlab.bkash.presentation.utils.DrawerMenuItem


@Preview(showSystemUi = true)
@Composable
fun FragmentScreen() {
    //scroll state
    val lazyScrollState = rememberScrollState()


    //animation
    val bottomItemList = listOf(
        BottomBarItem.Home,
        BottomBarItem.Inbox
    )
    val bottomBarSelectedItem = remember {
        mutableStateOf(bottomItemList[0])
    }
    //for drawer menu
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    val scrollState = rememberScrollState()
    val drawerList = listOf<DrawerMenuItem>(
        DrawerMenuItem.Home,
        DrawerMenuItem.Divider,
        DrawerMenuItem.Statement,
        DrawerMenuItem.Divider,
        DrawerMenuItem.Limit,
        DrawerMenuItem.Divider,
        DrawerMenuItem.Coupon,
        DrawerMenuItem.Divider,
        DrawerMenuItem.UpdateInfo,
        DrawerMenuItem.Divider,
        DrawerMenuItem.Refer,
        DrawerMenuItem.Divider,
        DrawerMenuItem.BkashMap,
        DrawerMenuItem.Divider,
        DrawerMenuItem.BkashInfo,
        DrawerMenuItem.Divider,
        DrawerMenuItem.Settings,
        DrawerMenuItem.Divider,
        DrawerMenuItem.AutoPay,
        DrawerMenuItem.Divider,
        DrawerMenuItem.Support,
        DrawerMenuItem.Divider,
        DrawerMenuItem.Logout,
    )
    val drawerSelectedItem = remember {
        mutableStateOf(drawerList[0])
    }


    val floatingActionButton = BottomBarItem.QrScanner

    Scaffold(
        scaffoldState = scaffoldState,
         topBar = { HomeTopAppbar(scope, scaffoldState) },
        bottomBar = {
            BottomAppBar(cutoutShape = CircleShape, backgroundColor = Color.White) {
                BottomBar(bottomItemList, bottomBarSelectedItem)
            }
        },

        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        floatingActionButton = {
            FloatingActionButton(
                shape = CircleShape,
                modifier = Modifier.padding(10.dp),
                onClick = { /*TODO*/ },
                contentColor = Color.Unspecified,
                backgroundColor = Color.White,
            ) {
                Icon(
                    painter = androidx.compose.ui.res.painterResource(
                        id = floatingActionButton.icon
                    ),
                    contentDescription = floatingActionButton.title,
                    modifier = Modifier.size(35.dp)
                )
            }
        },

        drawerContent = {
            DrawerMenu(
                menuItem = drawerList,
                scrollState = scrollState,
                scaffoldState = scaffoldState,
                scope = scope,
                selectedItem = drawerSelectedItem
            )
        }
    ) { padding ->
        HomeScreen(lazyScrollState)
    }
}
