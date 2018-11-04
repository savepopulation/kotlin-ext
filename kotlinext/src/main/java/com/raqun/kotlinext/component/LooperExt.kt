package com.raqun.kotlinext.component

import android.os.Looper

/**
 * Returns if current looper is Main
 */
fun Looper.isMain() = this == Looper.getMainLooper()