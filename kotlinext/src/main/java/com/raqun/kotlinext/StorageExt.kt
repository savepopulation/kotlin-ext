package com.raqun.kotlinext

fun Long.convertBytesToHumanReadableForm(si: Boolean): String {
    val unit = if (si) 1000 else 1024
    if (this < unit) return toString() + " B"
    val exp = (Math.log(toDouble()) / Math.log(unit.toDouble())).toInt()
    val pre = (if (si) "kMGTPE" else "KMGTPE")[exp - 1] + if (si) "" else "i"
    return String.format("%.1f %sB", this / Math.pow(unit.toDouble(), exp.toDouble()), pre)
}