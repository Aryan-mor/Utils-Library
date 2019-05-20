package com.aryanmo.utils.utils

import android.util.Log

fun Any.toInt(): Int {
    return try {
        when (this) {
            is String -> Regex("([0-9])*").find(this)!!.value.toInt()
            is Double -> this.toInt()
            is Float -> Math.round(this)
            is Long -> this.toInt()
            is Boolean -> return if (!this) 0 else 1
            else -> throw Exception()
        }
    } catch (e: Exception) {
        Log.e("ConverterUtils", "toInt() couldn't convert param")
        -1
    }
}

fun toFloat(s: String): Float {
    return s.toFloat()
}