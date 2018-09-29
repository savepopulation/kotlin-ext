package com.raqun.kotlinext

import android.content.Context
import android.widget.TextView

/**
 * Copies TextView text to clipboard with given label
 */
fun TextView.copyToClipboard(label : String) {
    if(text != null) {
        val currentSdk = android.os.Build.VERSION.SDK_INT

        if (currentSdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
            val manager: android.text.ClipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE)
                    as android.text.ClipboardManager
            manager.text = text
        } else {
            val manager: android.content.ClipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE)
                    as android.content.ClipboardManager
            manager.primaryClip = android.content.ClipData.newPlainText(label, text)
        }
    }
}