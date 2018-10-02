package com.raqun.kotlinext

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Inits visiblity of a view.
 */
fun View.initVisiblity(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}

/**
 * Inflates a view wtih given id.
 */
fun ViewGroup.inflate(@LayoutRes resId: Int) = LayoutInflater.from(this.context).inflate(resId, this, false)