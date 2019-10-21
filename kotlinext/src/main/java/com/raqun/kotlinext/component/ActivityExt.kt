package com.raqun.kotlinext.component

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.support.v7.app.AlertDialog
import android.view.View
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

/**
 * Hides Status and Navigation Bar
 */
fun Activity.hideStatusAndNavigationBar() {
    window.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN;
    actionBar?.hide()
}

/*
* Get Activity status bar
 */
fun Activity.getStatusBarHeight() : Int{
    var result : Int = 0
    val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
    if(resourceId > 0){
        result = resources.getDimensionPixelSize(resourceId)
    }
    return result
}
