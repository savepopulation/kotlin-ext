package com.raqun.kotlinext

import android.app.ActivityManager
import android.content.Context
import android.content.Context.ACTIVITY_SERVICE
import android.content.Intent
import android.widget.Toast

/**
 * Checks if a Broadcast can be resolved
 */
fun Context.canResolveBroadcast(intent: Intent) = packageManager.queryBroadcastReceivers(intent, 0).isNotEmpty()

/**
 * Checks if a Provider exists with given name
 */
fun Context.providerExists(providerName: String) = packageManager.resolveContentProvider(providerName, 0) != null

/**
 * Creates a toast message with given message and duration
 */
fun Context.alert(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, message, duration).show()

/**
 * Checks if a service with given name is running.
 */
fun Context.isServiceRunning(serviceName: String): Boolean {
    val manager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
    for (service in manager.getRunningServices(Integer.MAX_VALUE)) {
        if (serviceName == service.service.className) {
            return true
        }
    }
    return false
}