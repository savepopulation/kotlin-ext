package com.raqun.kotlinext

import android.os.Looper

fun Looper.isMain() = this == Looper.getMainLooper()