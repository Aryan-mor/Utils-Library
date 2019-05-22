package com.aryanmo.utils.utils

import android.content.Context
import com.aryanmo.utils.utils.log.logError


fun Context.addPref(key: String, value: Any): Boolean {
    val pr = SecurePreferences(this)
    when (value) {
        is String -> pr.edit().putString(key, value).apply()
        is Boolean -> pr.edit().putBoolean(key, value).apply()
        is Int -> pr.edit().putInt(key, value).apply()
        is Float -> pr.edit().putFloat(key, value).apply()
        is Long -> pr.edit().putLong(key, value).apply()
        else -> {
            try {
                pr.edit().putString(key, value.toJson()).commit()
            } catch (e: Exception) {
                return false
            }
        }
    }
    return true
}

fun Context.getPrefBoolean(key: String, defaultValue: Boolean): Boolean {
    val pr = SecurePreferences(this)
    return pr.getBoolean(key, defaultValue)
}

fun Context.getPrefString( key: String, defaultValue: String): String {
    val pr = SecurePreferences(this)
    return pr.getString(key, defaultValue)
}

fun Context.getPrefInt(key: String, defaultValue: Int): Int {
    val pr = SecurePreferences(this)
    return pr.getInt(key, defaultValue)
}

fun Context.getPrefFloat( key: String, defaultValue: Float): Float {
    val pr = SecurePreferences(this)
    return pr.getFloat(key, defaultValue)
}

fun Context.getPrefLong(key: String, defaultValue: Long): Long {
    val pr = SecurePreferences(this)
    return pr.getLong(key, defaultValue)
}

fun <T> Context.getPref(key: String, classOf: Class<T>): T? {
    try {
        val s = this.getPrefString( key, "")
        if (s != "") {
            return fromJson(s, classOf)
        }

        val i = this.getPrefInt(key, -1)
        if (i != -1)
            return i as T

        val f = this.getPrefFloat( key, -1f)
        if (f != -1f)
            return f as T

        val l = this.getPrefLong( key, -1L)
        if (l != -1L)
            return l as T
        return this.getPrefBoolean( key, false) as T
    } catch (e: Exception) {
        logError("UtilsLibrary::getPref", e)
        return null
    }
}
