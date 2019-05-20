package com.aryanmo.utils.utils

import com.google.gson.Gson

fun Any.toJson(): String? {
    return Gson().toJson(this)
}

@Deprecated("This function is deprecated", ReplaceWith("String.hydrate(classOf)"))
fun <T> fromJson(json: String, classOf: Class<T>): T? {
    return json.hydrate(classOf)
}

fun <T> String.jsonConvertTo(classOf: Class<T>): T? {
    return this.hydrate(classOf)
}

fun <T> String.hydrate(classOf: Class<T>): T? {
    return try {
        Gson().fromJson<T>(this, classOf)!!
    } catch (e: Exception) {
        try {
            this as T
        } catch (e: Exception) {
            null
        }
    }
}