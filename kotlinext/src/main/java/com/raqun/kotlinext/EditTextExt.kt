package com.raqun.kotlinext

import android.content.Context
import android.text.TextUtils
import android.widget.EditText
import java.net.MalformedURLException
import java.net.URL

/**
 * Clears EditText
 */
fun EditText.clear() {
    setText("")
}

/**
 * returns EditText text as URL
 */
fun EditText.getUrl(): URL? {
    return try {
        URL(text.toString())
    } catch (e: MalformedURLException) {
        null
    }
}

/**
 * Sets EditText text from Clipboard
 */
fun EditText.pasteFromClipBoard() {
    var text = ""
    val currentSdk = android.os.Build.VERSION.SDK_INT
    if (currentSdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
        val manager: android.text.ClipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE)
                as android.text.ClipboardManager
        try {
            text = manager.text.toString()
        } catch (e: Exception) {
            // ignored
        }
    } else {
        val manager: android.content.ClipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE)
                as android.content.ClipboardManager
        manager.primaryClip?.let {
            val item = manager.primaryClip.getItemAt(0)
            text = item.text.toString()
        }
    }

    if (!TextUtils.isEmpty(text)) setText(text)
}