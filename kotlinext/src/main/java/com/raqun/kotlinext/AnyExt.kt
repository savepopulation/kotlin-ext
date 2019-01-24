package com.raqun.kotlinext

/**
 * Checks if any object is not null
 */
fun Any?.isNotNull() = this != null

/**
 * Checks if any object is null
 */
fun Any?.isNull() = this == null

/**
 * Try-catch
 */
fun Any.tryCatch(tryBlock: () -> Unit,
                 catchBlock: ((t: Throwable) -> Unit)? = null,
                 finalBlock: (() -> Unit)? = null) {
    try {
        tryBlock()
    } catch (e: Exception) {
        catchBlock?.invoke(e)
    } finally {
        finalBlock?.invoke()
    }
}