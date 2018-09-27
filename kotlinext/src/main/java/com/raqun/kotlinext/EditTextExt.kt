package com.raqun.kotlinext

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