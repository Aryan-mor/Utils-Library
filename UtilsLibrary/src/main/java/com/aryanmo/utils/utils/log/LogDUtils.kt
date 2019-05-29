package com.aryanmo.utils.utils.log

import android.content.Context
import com.aryanmo.utils.utils.FLAG


fun logD(context: Context?, logMessage: Any, logFlag: String = FLAG) =
    log(context, logMessage, logFlag, LOG_DEBUG_MODE)

fun logD(logMessage: Any, logFlag: String = FLAG) = log(logMessage, logFlag, LOG_DEBUG_MODE)

fun Any.logThisD(context: Context?, logFlag: String = FLAG) =
    this.logThis(context = context, logFlag = logFlag, logType = LOG_DEBUG_MODE)

fun Any.logThisD(logFlag: String = FLAG) =
    this.logThis(logFlag = logFlag, logType = LOG_DEBUG_MODE)

fun String.logDJson(logFlag: String = FLAG) =
    this.logJson(logFlag = logFlag, logType = LOG_DEBUG_MODE)

fun Map<*, *>.logThisD(logFlag: String = FLAG) =
    this.logThis(logFlag = logFlag, logType = LOG_DEBUG_MODE)

fun List<*>.logThisD(logFlag: String = FLAG) =
    this.logThis(logFlag = logFlag, logType = LOG_DEBUG_MODE)
