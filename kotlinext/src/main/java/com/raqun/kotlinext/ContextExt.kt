package com.raqun.kotlinext

import android.content.Context
import android.content.Intent

/**
 * Checks if a Broadcast can be resolved
 */
fun Context.canResolveBroadcast(intent: Intent) = packageManager.queryBroadcastReceivers(intent, 0).isNotEmpty()

/**
 * Checks if a Provider exists with given name
 */
fun Context.providerExists(providerName: String) = packageManager.resolveContentProvider(providerName, 0) != null