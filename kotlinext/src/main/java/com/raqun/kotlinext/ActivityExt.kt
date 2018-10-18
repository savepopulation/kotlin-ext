package com.raqun.kotlinext

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.support.v7.app.AlertDialog
import android.view.inputmethod.InputMethodManager

/**
 * Force close keyboard
 */
fun Activity.forceCloseKeyboard() {
    if (currentFocus != null) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus.windowToken, 0)
    }
}

/**
 * Get activity's orientation is Portrait or not
 */
fun Activity.isPortrait() = this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT

/**
 * Simplify using AlertDialog
 */
inline fun Activity.alert(body: AlertDialog.Builder.() -> AlertDialog.Builder) {
    AlertDialog.Builder(this)
            .body()
            .show()
}