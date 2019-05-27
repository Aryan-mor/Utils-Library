package com.aryanmo.utils.utils.log

import android.content.Context
import com.aryanmo.utils.utils.FLAG

fun logV(context: Context?, logMessage: Any, logFlag: String = FLAG) =
    log(context, logMessage, logFlag, LOG_DEBUG_MODE)

fun logV(logMessage: Any, logFlag: String = FLAG) = log(logMessage, logFlag, LOG_DEBUG_MODE)

fun Any.logThisV(context: Context?, logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logThis(context = context, logFlag = logFlag, logType = logType)

fun Any.logThisV(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logThis(logFlag = logFlag, logType = logType)

fun String.logVJson(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logJson(logFlag = logFlag, logType = logType)

fun Map<*, *>.logThisV(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logThis(logFlag = logFlag, logType = logType)

fun List<*>.logThisV(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logThis(logFlag = logFlag, logType = logType)