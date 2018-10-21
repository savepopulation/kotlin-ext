package com.raqun.kotlinext.view

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
 * Inflates a view with given id.
 */
fun ViewGroup.inflate(@LayoutRes resId: Int) = LayoutInflater.from(this.context).inflate(resId, this, false)

/***
 * Hides or shows view with given predicate
 */
inline fun <T : View> T.showIf(predicate: (T) -> Boolean) {
    if (predicate(this)) {
        show()
    } else {
        hide()
    }
}

/**
 * Shows view
 */
fun View.show() {
    visibility = View.VISIBLE
}

/***
 * Hides view
 */
fun View.hide() {
    visibility = View.GONE
}