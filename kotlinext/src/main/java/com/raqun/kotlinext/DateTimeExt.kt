package com.raqun.kotlinext

/*
 * Converts date with 0 prefix format
 */
fun Int.convertDateWithPrefix() : String{
    return if(this <10){
        "0${this}"
    } else{
        this.toString()
    }
}