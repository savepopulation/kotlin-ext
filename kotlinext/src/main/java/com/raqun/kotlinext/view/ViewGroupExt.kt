package com.raqun.kotlinext.view

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText

/**
 * Inflates a view with given id.
 */
fun ViewGroup.inflate(@LayoutRes resId: Int) = LayoutInflater.from(this.context).inflate(resId, this, false)

/**
 * Gets Child View at index
 */
inline operator fun ViewGroup.get(i: Int): View? = getChildAt(i)

/**
 * Remvoes child View with -=
 */
inline operator fun ViewGroup.minusAssign(child: View) = removeView(child)

/**
 * Adds a View with +=
 */
inline operator fun ViewGroup.plusAssign(child: View) = addView(child)

/**
 * Applys given func to all child views
 */
inline fun ViewGroup.eachChild(func: (view: View) -> Unit) {
    for (i in 0 until childCount) {
        func(getChildAt(i))
    }
}

/**
 * Hides all child views
 */
fun ViewGroup.hideAll() {
    eachChild {
        it.hide()
    }
}

/**
 * SHows all child views
 */
fun ViewGroup.showAll() {
    eachChild {
        it.show()
    }
}

