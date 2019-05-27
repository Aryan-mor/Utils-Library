package com.aryanmo.utils.utils.log

import android.content.Context
import com.aryanmo.utils.utils.FLAG

fun logW(context: Context?, logMessage: Any, logFlag: String = FLAG) =
    log(context, logMessage, logFlag, LOG_DEBUG_MODE)

fun logW(logMessage: Any, logFlag: String = FLAG) = log(logMessage, logFlag, LOG_DEBUG_MODE)

fun Any.logThisW(context: Context?, logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logThis(context = context, logFlag = logFlag, logType = logType)

fun Any.logThisW(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logThis(logFlag = logFlag, logType = logType)

fun String.logWJson(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logJson(logFlag = logFlag, logType = logType)

fun Map<*, *>.logThisW(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logThis(logFlag = logFlag, logType = logType)

fun List<*>.logThisW(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logThis(logFlag = logFlag, logType = logType)