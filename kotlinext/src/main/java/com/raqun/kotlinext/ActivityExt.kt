package com.raqun.kotlinext

import android.app.Activity
import android.content.Context
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