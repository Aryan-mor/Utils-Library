package com.aryanmo.utils.utils.log

import android.content.Context
import com.aryanmo.utils.utils.FLAG

fun logW(context: Context?, logMessage: Any, logFlag: String = FLAG) =
    log(context, logMessage, logFlag, LOG_WARN_MODE)

fun logW(logMessage: Any, logFlag: String = FLAG) = log(logMessage, logFlag, LOG_WARN_MODE)

fun Any.logThisW(context: Context?, logFlag: String = FLAG) =
    this.logThis(context = context, logFlag = logFlag, logType = LOG_WARN_MODE)

fun Any.logThisW(logFlag: String = FLAG) =
    this.logThis(logFlag = logFlag, logType = LOG_WARN_MODE)

fun String.logWJson(logFlag: String = FLAG) =
    this.logJson(logFlag = logFlag, logType = LOG_WARN_MODE)

fun Map<*, *>.logThisW(logFlag: String = FLAG) =
    this.logThis(logFlag = logFlag, logType = LOG_WARN_MODE)

fun List<*>.logThisW(logFlag: String = FLAG) =
    this.logThis(logFlag = logFlag, logType = LOG_WARN_MODE)