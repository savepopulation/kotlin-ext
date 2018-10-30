package com.raqun.kotlinext.view

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Inflates a view with given id.
 */
fun ViewGroup.inflate(@LayoutRes resId: Int) = LayoutInflater.from(this.context).inflate(resId, this, false)