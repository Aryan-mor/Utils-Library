package com.aryanmo.utils.utils.log

import android.content.Context
import android.util.Log
import com.aryanmo.utils.utils.FLAG
import com.aryanmo.utils.utils.getString
import com.aryanmo.utils.utils.hydrate


val LOG_VISIBILITY = true
val LOG_DEBUG_MODE = 1
val LOG_ERROR_MODE = 2
val LOG_INFO_MODE = 3
val LOG_VERBOSE_MODE = 4
val LOG_WARN_MODE = 5
val LOG_WTF_MODE = 6
var DEFAULT_LOG_MODE = LOG_INFO_MODE

fun log(context: Context?, logMessage: Any, logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) {
    if (!LOG_VISIBILITY)
        return
    var logMe = if (logMessage is Boolean) "Boolean -> $logMessage" else logMessage
    logMe = logMe.toString()
    if (context != null) {
        logMe = context.getString(logMe)
    }
    val logFl: String = logFlag
    when (logType) {
        LOG_INFO_MODE -> Log.i(logFl, logMe)
        LOG_ERROR_MODE -> Log.e(logFl, logMe)
        LOG_DEBUG_MODE -> Log.d(logFl, logMe)
        LOG_VERBOSE_MODE -> Log.v(logFl, logMe)
        LOG_WARN_MODE -> Log.w(logFl, logMe)
        LOG_WTF_MODE -> Log.wtf(logFl, logMe)
        else -> Log.i(logFl, logMe)
    }
}

fun log(logMessage: Any, logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    log(null, logMessage, logFlag, logType)

fun logError(title: String, message: String = "error message null", logFlag: String = FLAG) {
    log("$title error || ErrorMessage -> $message", logFlag, LOG_ERROR_MODE)
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





