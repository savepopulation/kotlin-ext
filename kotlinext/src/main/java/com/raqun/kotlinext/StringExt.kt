package com.raqun.kotlinext

/*
Checks a String is null or empty
*/
fun String?.isNotNullOrBlank() = this != null && this.trim().isNotEmpty()
