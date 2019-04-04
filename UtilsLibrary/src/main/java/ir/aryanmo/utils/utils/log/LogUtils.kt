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
var DEFAULT_LOG_MODE = INFO_MODE

fun log(context: Context?, logMessage: Any, logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) {
    if (!LOG_VISIBILITY)
        return
    var logMe = if (logMessage is Boolean) "Boolean -> $logMessage" else logMessage
    logMe = logMe.toString()
    if (context != null) {
        logMe = getString(context, logMe)
    }
    val logFl: String = logFlag!!
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

fun log(logMessage: Any, logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    log(null, logMessage, logFlag, logType)

fun log(key: Any, value: Any, logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) {
    log("key -> $key  ||  value -> $value", logFlag, logType)
}

fun log(map: Map<Any, Any>?, logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) {
    try {
        if (map == null || map.isEmpty())
            throw Exception("map is null")
        log("**** logString Start ****")
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
        log("**** logString End ****")
    } catch (e: Exception) {
        logError("LogUtils::log(Map<Any, Any> map)", e)
    }
}

fun log(hashMap: HashMap<Any, Any>?, logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) {
    try {
        if (hashMap == null || hashMap.isEmpty())
            throw Exception("map is null")
        log("**** logString Start ****", logType = logType)
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
        log("**** logString End ****", logType = logType)
    } catch (e: Exception) {
        logError("LogUtils::log(HashMap<Any, Any> hashMap)", e)
    }

}

fun log(list: List<Any>, logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) {
    for (s in list) {
        try {
            log(s.toString(), logFlag, logType)
        } catch (e: Exception) {
            logError("log(strings: List<Any>) item error", e)
        }
    }
}

fun logGson(json: String, logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) {
    val gson = Gson()
    val map = gson.fromJson(json, HashMap::class.java)
    log(map, logFlag, logType)
}

fun logError(title: String, message: String = "error message null", logFlag: String = FLAG) {
    log("$title error || ErrorMessage -> $message", logFlag)
}

fun logError(title: String, e: Exception, logFlag: String = FLAG) =
    logError(title, e.message ?: "error message null", logFlag)

fun logError(title: String, e: Throwable?, logFlag: String = FLAG) =
    logError(title, e?.message ?: "error message null", logFlag)

fun logNullPointerExceptionError(title: String, message: String = "error message null", logFlag: String = FLAG) {
    log("$title NullPointerException || ErrorMessage -> $message", logFlag)
}

fun logNullPointerExceptionError(title: String, e: Exception, logFlag: String = FLAG) =
    logNullPointerExceptionError(title, e.message ?: "error message null", logFlag)
