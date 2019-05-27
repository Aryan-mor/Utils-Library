package com.aryanmo.utils.utils.log

import android.content.Context
import com.aryanmo.utils.utils.FLAG

fun logE(context: Context?, logMessage: Any, logFlag: String = FLAG) =
    log(context, logMessage, logFlag, LOG_DEBUG_MODE)

fun logE(logMessage: Any, logFlag: String = FLAG) = log(logMessage, logFlag, LOG_DEBUG_MODE)

fun Any.logThisE(context: Context?, logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logThis(context = context, logFlag = logFlag, logType = logType)

fun Any.logThisE(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logThis(logFlag = logFlag, logType = logType)

fun String.logEJson(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logJson(logFlag = logFlag, logType = logType)

fun Map<*, *>.logThisE(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logThis(logFlag = logFlag, logType = logType)

fun List<*>.logThisE(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logThis(logFlag = logFlag, logType = logType)
