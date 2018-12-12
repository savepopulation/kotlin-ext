package com.raqun.kotlinext

/*
Checks a String is null or empty
*/
fun String?.isNullOrEmpty() = this != null && this.trim().isNotEmpty()