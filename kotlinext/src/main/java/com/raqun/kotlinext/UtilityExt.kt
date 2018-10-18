package com.raqun.kotlinext

import android.app.Activity
import android.os.Build
import android.support.v7.app.AlertDialog

/**
 * execute "func" if current version is grater than or equal to given version
 */
inline fun supportsVersion(ver: Int, func: () -> Unit) {
    if (Build.VERSION.SDK_INT >= ver) {
        func.invoke()
    }
}

/**
 * execute "body" if app in debug mode
 */
inline fun debug(body: () -> Unit) {
    if (BuildConfig.DEBUG)
        body()
}

/**
 * Simplify using AlertDialog
 */
inline fun Activity.alert(body: AlertDialog.Builder.() -> AlertDialog.Builder) {
    AlertDialog.Builder(this)
            .body()
            .show()
}