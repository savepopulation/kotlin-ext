package com.raqun.kotlinext.view

import android.support.v4.view.ViewPager

/**
 * Checks if ViewPager can swipe back.
 */
fun ViewPager.canGoBack() = currentItem > 0

/**
 * Checks if ViewPager can swipe next
 */
fun ViewPager.canGoNext() = adapter != null && currentItem < adapter!!.count - 1

/**
 * Swipes ViewPager back
 */
fun ViewPager.goPrevious() {
    if (canGoBack()) currentItem -= 1
}

/**
 * Swipes ViewPager next
 */
fun ViewPager.goNext() {
    if (canGoNext()) currentItem += 1
}