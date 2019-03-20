package ir.aryanmo.utils.utils

import android.content.Context
import com.google.gson.Gson
import ir.aryanmo.utils.utils.log.logError
import java.lang.Exception


fun addPref(context: Context, key: String, value: Any): Boolean {
    val pr = SecurePreferences(context)
    when (value) {
        is String -> pr.edit().putString(key, value).apply()
        is Boolean -> pr.edit().putBoolean(key, value).apply()
        is Int -> pr.edit().putInt(key, value).apply()
        is Float -> pr.edit().putFloat(key, value).apply()
        is Long -> pr.edit().putLong(key, value).apply()
        else -> {
            try {
                pr.edit().putString(key, Gson().toJson(value)).commit()
            } catch (e: Exception) {
                return false
            }
        }
    }
    return true
}

fun getPrefBoolean(context: Context, key: String, defaultValue: Boolean): Boolean {
    val pr = SecurePreferences(context)
    return pr.getBoolean(key, defaultValue)
}

fun getPrefString(context: Context, key: String, defaultValue: String): String {
    val pr = SecurePreferences(context)
    return pr.getString(key, defaultValue)
}

fun getPrefInt(context: Context, key: String, defaultValue: Int): Int {
    val pr = SecurePreferences(context)
    return pr.getInt(key, defaultValue)
}

fun getPrefFloat(context: Context, key: String, defaultValue: Float): Float {
    val pr = SecurePreferences(context)
    return pr.getFloat(key, defaultValue)
}

fun getPrefLong(context: Context, key: String, defaultValue: Long): Long {
    val pr = SecurePreferences(context)
    return pr.getLong(key, defaultValue)
}

fun <T> getPref(context: Context, key: String, classOf: Class<T>): T? {
    try {
        val s = getPrefString(context, key, "")
        if (s != "") {
            return try {
                Gson().fromJson<T>(s, classOf)!!
            } catch (e: Exception) {
                s as T
            }
        }

        val i = getPrefInt(context, key, -1)
        if (i != -1)
            return i as T

        val f = getPrefFloat(context, key, -1f)
        if (f != -1f)
            return f as T

        val l = getPrefLong(context, key, -1L)
        if (l != -1L)
            return l as T
        return getPrefBoolean(context, key, false) as T
    } catch (e: Exception) {
        logError("UtilsLibrary::getPref", e)
        return null
    }
}
