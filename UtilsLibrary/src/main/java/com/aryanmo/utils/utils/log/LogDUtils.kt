package com.aryanmo.utils.utils.log

import android.content.Context
import com.aryanmo.utils.utils.FLAG


fun logD(context: Context?, logMessage: Any, logFlag: String = FLAG) =
    log(context, logMessage, logFlag, LOG_DEBUG_MODE)

fun logD(logMessage: Any, logFlag: String = FLAG) = log(logMessage, logFlag, LOG_DEBUG_MODE)

fun Any.logThisD(context: Context?, logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logThis(context = context, logFlag = logFlag, logType = logType)

fun Any.logThisD(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logThis(logFlag = logFlag, logType = logType)

fun String.logDJson(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logJson(logFlag = logFlag, logType = logType)

fun Map<*, *>.logThisD(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logThis(logFlag = logFlag, logType = logType)

fun List<*>.logThisD(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logThis(logFlag = logFlag, logType = logType)
