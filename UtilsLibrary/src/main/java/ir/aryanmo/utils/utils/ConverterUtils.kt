package ir.aryanmo.utils.utils

import android.util.Log

fun toString(any: Any): String {
        return try {
            any.toString()
        } catch (e: java.lang.Exception) {
            ""
        }
    }

    fun toInt(any: Any): Int {
        return try {
            when (any) {
                is String -> Regex("([0-9])*").find(any)!!.value.toInt()
                is Float -> Math.round(any)
                is Long -> any.toInt()
                is Boolean -> return if (!any) 0 else 1
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

