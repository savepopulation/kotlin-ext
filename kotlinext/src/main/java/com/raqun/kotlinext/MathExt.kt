package com.raqun.kotlinext

/*
  Mathematical operations of double numbers
 */
fun Double.sin() : Double = Math.sin(this)
fun Double.cos() : Double = Math.cos(this)
fun Double.tan() : Double = Math.tan(this)
fun Double.log() : Double = Math.log(this)
fun Double.log10() : Double = Math.log10(this)
fun Double.floor(): Double = Math.floor(this)
fun Double.ceil() : Double = Math.ceil(this)
fun Double.pow(exp: Double) : Double = Math.pow(this,exp)