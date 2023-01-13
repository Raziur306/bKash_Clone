package com.eritlab.bkash.presentation.utils

import com.eritlab.bkash.R
import com.eritlab.bkash.presentation.Screen

sealed class BottomBarItem(val route: String, val icon: Int, val title: String) {
    object Home : BottomBarItem(Screen.HomeScreen.route, R.drawable.home, "হোম")
    object Inbox : BottomBarItem(Screen.InboxScreen.route, R.drawable.inbox, "ইনবক্স")
    object QrScanner : BottomBarItem(Screen.QRScreen.route, R.drawable.qr_code_cerise, "QR স্ক্যান")
}
