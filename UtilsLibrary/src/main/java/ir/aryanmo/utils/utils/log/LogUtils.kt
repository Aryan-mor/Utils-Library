package ir.aryanmo.utils.utils.log

import android.content.Context
import android.support.v7.appcompat.R.id.message
import android.util.Log
import com.google.gson.Gson
import ir.aryanmo.utils.utils.FLAG
import ir.aryanmo.utils.utils.getString

import java.util.HashMap


val LOG_VISIBILITY = true
val DEBUG_MODE = 1
val ERROR_MODE = 2
val INFO_MODE = 3
val VERBOSE_MODE = 4
val WARN_MODE = 5
val WTF_MODE = 6
var DEFAULT_LOG_MODE = ERROR_MODE

fun log(context: Context?, logMessage: Any, logFlag: String?, logType: Int) {
    if (!LOG_VISIBILITY)
        return
    var logMe = if (logMessage is Boolean) "Boolean -> $logMessage" else logMessage
    logMe = logMe.toString()
    if (context != null) {
        logMe = getString(context, logMe)
    }
    val logFl: String = logFlag ?: FLAG
    when (logType) {
        INFO_MODE -> Log.i(logFl, logMe)
        ERROR_MODE -> Log.e(logFl, logMe)
        DEBUG_MODE -> Log.d(logFl, logMe)
        VERBOSE_MODE -> Log.v(logFl, logMe)
        WARN_MODE -> Log.w(logFl, logMe)
        WTF_MODE -> Log.wtf(logFl, logMe)
        else -> Log.i(logFl, logMe)
    }
}

fun log(context: Context?, logMessage: Any, logFlag: String?) = log(context, logMessage, logFlag, DEFAULT_LOG_MODE)

fun log(context: Context?, logMessage: Any, logType: Int) = log(context, logMessage, null, logType)

fun log(context: Context?, logMessage: Any) = log(context, logMessage, null, DEFAULT_LOG_MODE)

fun log(logMessage: Any, logFlag: String?, logType: Int) = log(null, logMessage, logFlag, logType)

fun log(logMessage: Any, logFlag: String?) = log(logMessage, logFlag, DEFAULT_LOG_MODE)

fun log(logMessage: Any, logType: Int) = log(logMessage, null, logType)

fun log(logMessage: Any) = log(logMessage, null, DEFAULT_LOG_MODE)

fun log(key: Any, value: Any, logFlag: String?, logType: Int) {
    log("key -> $key  ||  value -> $value", logFlag, logType)
}

fun log(key: Any, value: Any, logFlag: String?) {
    log("key -> $key  ||  value -> $value", logFlag, DEFAULT_LOG_MODE)
}

fun log(key: Any, value: Any, logType: Int) {
    log("key -> $key  ||  value -> $value", null, logType)
}

fun log(key: Any, value: Any) {
    log("key -> $key  ||  value -> $value")
}

fun log(map: Map<Any, Any>?, logFlag: String?, logType: Int) {
    try {
        if (map == null || map.isEmpty())
            throw Exception("map is null")
        log("**** logString Start ****", null)
        for ((key, value) in map) {
            try {
                if (value is Boolean) {
                    log(key, value)
                    continue
                }
                log("Key: $key   |   Value: $value", logFlag, logType)
            } catch (e: Exception) {
                logError("LogUtils::log(Map<Any, Any> map) in for", e)
            }

        }
        log("**** logString End ****", null)
    } catch (e: Exception) {
        logError("LogUtils::log(Map<Any, Any> map)", e)
    }
}

fun log(map: Map<Any, Any>?, logFlag: String?) = log(map, logFlag, DEFAULT_LOG_MODE)

fun log(map: Map<Any, Any>?, logType: Int) = log(map, null, logType)

fun log(map: Map<Any, Any>?) = log(map, null, DEFAULT_LOG_MODE)

fun log(hashMap: HashMap<Any, Any>?, logFlag: String?, logType: Int) {
    try {
        if (hashMap == null || hashMap.isEmpty())
            throw Exception("map is null")
        log("**** logString Start ****", null, logType)
        for ((key, value) in hashMap) {
            try {
                if (value is Boolean) {
                    log(key, value)
                    continue
                }
                log("Key: $key   |   Value: $value", logFlag, logType)
            } catch (e: Exception) {
                logError("LogUtils::log(HashMap<Any, Any> hashMap) in for", e)
            }

        }
        log("**** logString End ****", null, logType)
    } catch (e: Exception) {
        logError("LogUtils::log(HashMap<Any, Any> hashMap)", e)
    }

}

fun log(hashMap: HashMap<Any, Any>?, logFlag: String?) {
    log(hashMap, logFlag, DEFAULT_LOG_MODE)
}

fun log(hashMap: HashMap<Any, Any>?) = log(hashMap, null)

fun log(list: List<Any>, logFlag: String?, logType: Int) {
    for (s in list) {
        try {
            log(s.toString(), logFlag, logType)
        } catch (e: Exception) {
            logError("log(strings: List<Any>) item error", e)
        }
    }
}

fun log(list: List<Any>, logFlag: String?) = log(list, logFlag, DEFAULT_LOG_MODE)

fun log(list: List<Any>, logType: Int) = log(list, null, logType)

fun log(list: List<Any>) = log(list, null)

fun logGson(json: String, logFlag: String?, logType: Int) {
    val gson = Gson()
    val map = gson.fromJson(json, HashMap::class.java)
    log(map, logFlag, logType)
}

fun logGson(json: String, logFlag: String?) {
    logGson(json, logFlag, DEFAULT_LOG_MODE)
}

fun logGson(json: String, logType: Int) {
    logGson(json, null, logType)
}

fun logGson(json: String) {
    logGson(json, null, DEFAULT_LOG_MODE)
}

fun logError(title: String, e: Exception, logFlag: String?) {
    log("$title error || ErrorMessage -> $e.$message", logFlag)
}

fun logError(title: String, e: Exception) = logError(title, e, null)

fun logNullPointerExceptionError(title: String, e: Exception, logFlag: String?) {
    log(title + " NullPointerException || ErrorMessage -> " + e.message, logFlag)
}

fun logNullPointerExceptionError(title: String, e: Exception) = logNullPointerExceptionError(title, e, null)
