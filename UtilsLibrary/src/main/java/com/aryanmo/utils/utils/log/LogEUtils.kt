package com.aryanmo.utils.utils.log

import android.content.Context
import com.aryanmo.utils.utils.FLAG

fun logE(context: Context?, logMessage: Any, logFlag: String = FLAG) =
    log(context, logMessage, logFlag, LOG_ERROR_MODE)

fun logE(logMessage: Any, logFlag: String = FLAG) = log(logMessage, logFlag, LOG_ERROR_MODE)

fun Any.logThisE(context: Context?, logFlag: String = FLAG) =
    this.logThis(context = context, logFlag = logFlag, logType = LOG_ERROR_MODE)

fun Any.logThisE(logFlag: String = FLAG) =
    this.logThis(logFlag = logFlag, logType = LOG_ERROR_MODE)

fun String.logEJson(logFlag: String = FLAG) =
    this.logJson(logFlag = logFlag, logType = LOG_ERROR_MODE)

fun Map<*, *>.logThisE(logFlag: String = FLAG) =
    this.logThis(logFlag = logFlag, logType = LOG_ERROR_MODE)

fun List<*>.logThisE(logFlag: String = FLAG) =
    this.logThis(logFlag = logFlag, logType = LOG_ERROR_MODE)
