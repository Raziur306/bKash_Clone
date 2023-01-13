package com.eritlab.bkash.presentation.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DrawerMenuItem(
    val icon: ImageVector? = null,
    val title: String? = null,
    val isDivider: Boolean = false,
    val isHeader: Boolean = false,
) {
    object Home : DrawerMenuItem(icon = Icons.Default.Home, title = "হোম")
    object Statement :
        DrawerMenuItem(icon = Icons.Default.HorizontalDistribute, title = "স্টেটমেন্ট")

    object Limit : DrawerMenuItem(icon = Icons.Default.Warning, title = "লিমিট")
    object Coupon : DrawerMenuItem(icon = Icons.Default.Sell, title = "কুপন")
    object UpdateInfo : DrawerMenuItem(icon = Icons.Default.Update, title = "তথ্য হালনাগাদ")
    object Refer : DrawerMenuItem(icon = Icons.Default.Group, title = "রেফার বিকাশ অ্যাাপ")
    object BkashMap : DrawerMenuItem(icon = Icons.Default.PinDrop, title = "বিকাশ ম্যাপ")
    object BkashInfo : DrawerMenuItem(icon = Icons.Default.Explore, title = "বিকাশ নিয়ে জানুন")
    object Settings : DrawerMenuItem(icon = Icons.Default.Settings, title = "সেটিংস")
    object AutoPay : DrawerMenuItem(icon = Icons.Default.CurrencyExchange, title = "আটো পে")
    object Support : DrawerMenuItem(icon = Icons.Default.SupportAgent, title = "সাপোর্ট")
    object Logout : DrawerMenuItem(icon = Icons.Default.Logout, title = "লগ আউট")

    //divider
    object Divider : DrawerMenuItem(isDivider = true)
}