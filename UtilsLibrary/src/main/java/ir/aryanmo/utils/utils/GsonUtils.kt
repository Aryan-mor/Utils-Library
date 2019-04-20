package ir.aryanmo.utils.utils

import com.google.gson.Gson
import java.util.*


fun toJson(any: Any): String? {
   return Gson().toJson(any)
}

fun <T> fromJson(json: String, classOf: Class<T>): T? {
    return try {
        Gson().fromJson<T>(json, classOf)!!
    } catch (e: Exception) {
        try {
            json as T
        } catch (e: Exception) {
            null
        }
    }
}